Event.observe(window,'load',initDatePickers);
Event.observe(window,'load',initFormChangeTracker);

function initFormChangeTracker() {
	for (var i=0;i<document.forms.length;i++) {
		var frm = document.forms[i];
		addChangeTrackers($(frm));
	}
}

function addChangeTrackers(frm) {
	frm.getElements().each(function (el){
		Event.observe(el,'change',trackChange);
	});
}

function trackChange(el) {
	hasChanges = true;
	return true;
}

function initDatePickers() {
	var elements = $$('.date_picker_enabled');
	for (var i=0;i<elements.length;i++) {
		enableDatePicker(elements[i]);
	}
}

function getDatePickerImageFor(element) {
	var baseId = element.id;
	var iconId = baseId + '_picker_icon';
	var img = $(iconId);
	return img;
}

function enableDatePicker(element) {
	var baseId = element.id;
	var containerId = baseId+'_picker_container';
	var container = $(containerId);
	var img = getDatePickerImageFor(element);
	if (container!=null) {
		var cal = new YAHOO.widget.Calendar(baseId + 'Calendar', container, {
			title :"Choose a date:",
			close :true
		});
		cal.targetTextbox = element;
		cal.render();
		var anchor = img!=null?img:element;
		cal.anchor = anchor;
		cal.positionProperly = function() {
			this.show();
			var top = YAHOO.util.Dom.getXY(this.anchor)[1];/*anchor.cumulativeOffset().top;*/
			var left = YAHOO.util.Dom.getXY(this.anchor)[0] /*anchor.cumulativeOffset().left*/
					+ this.anchor.getWidth() + 1;
			YAHOO.util.Dom.setXY(container, [left,top]);
		};

		cal.selectEvent.subscribe(handleCalendarSelect, cal, true);
		Event.observe(element,'focus',function() {
			if (this.value=='') {
				//cal.show();
				cal.positionProperly();
			}
		});
		if (img!=null) {
			//YAHOO.util.Event.addListener(img, "click", cal.show, cal, true);
			YAHOO.util.Event.addListener(img, "click", cal.positionProperly, cal, true);
		}
	}
}

function handleCalendarSelect(type,args,obj) {
	    var dates = args[0];
	    var date = dates[0];
	    var year = date[0], month = date[1], day = date[2];
	    if (month<10) {
	    	month = "0"+month;
	    }
 	    if (day<10) {
	    	day = "0"+day;
	    }
	    var txtDate1 = obj.targetTextbox;
	    txtDate1.value = month + "/" + day + "/" + year;
	    obj.hide();
}


  function getContext(path){
     var parts = path.split("/");
     return parts[1];
  }


// Default-This function should be invoked before submitting to the server whenever
  // a Struts or HTML "submit" button click or keypress event occurs.
  // E.g:
  //    <html:submit
  //      styleId="LinkButton"
  //      onkeypress="return doAction(true,'doLink','AssignREADYPersonnel6050Page2');"
    //      onclick="return doAction(true,'doLink','AssignREADYPersonnel6050Page2');"
  //      styleClass="controlButton">
  //            <bean:message key="AssignReadyPersonel6050Form.Button.VIEWINDVDLQUAL.Text" />
  //  </html:submit>
  //
  // Note that this function does not actually submit a "submit" type input button
  // does this natively.
  //
  // This function provides an intermediary processing step prior to submitting to
  // the server, allowing us to perform operations before submitting.  One such such
  // operation is client-side input validation using Struts client-side validation to
  // detect invalid entries before incurring the expense of a server call.  Another
  // intemediary operation that this function facilitates is dispay a confirmation
  // messages by calling the "invokeAction..." javascript function that is present in
  // all JSPs.  Other intermediary processing may of course be added.  Note that
  // the doAction function must return TRUE for the server request to ooccur.  Returning
  // false cancels the HTML submit.
  //
  // parameters:
  // skipValidation -
  //    A flag indicating whether client-side input validation should occur. When set
  //    to true client side validation is NOT performed.
  //
  // actionName -
  //    The Struts action method to be invoked on the server (e.g. "doSave"). This
  //    function sets the form's "cmd" field to the actionName value.  Struts then
  //    uses the "cmd" attribute to determine which action method to execute
  //    on the server.  The "cmd" parameter must also be set for use by the Struts
  //    Form Validate() method which controls server side validation in accordance with
  //    the "cmd" being invoked.
  //
  // linkURL -
  //    Use only when the actionName is "doLink", otherwise set to NULL.  This parameter is
  //    a valid Struts forward name present in the struts-config.xml file.  It tells the
  //    doLink methods where what to display once the method's processing is done.
  //
var hasChanges = false;
function doAction(evtElement, skipValidation, actionName, linkURL, submitForm_0, skipConfirmation) {
	bCancel = skipValidation;
	var currForm = null;
	if (evtElement != undefined && evtElement.form != undefined) {
		currForm = evtElement.form;
	} else {
		currForm = findParentForm(evtElement);
		if (currForm == null) {
			currForm = document.forms[0];
		}
	}
	if (currForm == null) {
		alert("Unable to locate a Form element.");
	}
	//currForm.cmd.value = actionName;
	var inp = document.createElement('INPUT');
	inp.type='hidden';
	inp.name='method:'+actionName;
	$(currForm).appendChild(inp);

	if (linkURL && currForm.linkForwardName) {
		currForm.linkForwardName.value = linkURL;
	}
	if ((skipConfirmation == undefined) || (skipConfirmation == false)) {
		result = eval("invoke" + currForm.getAttributeNode("name").value + "Action(actionName)");
		if (result == false) {
			return false;
		}
	}
	if (!skipValidation) {
		var validationResult = performClientSideValidation(currForm);
		if (validationResult == false) {
			return false;
		}
	}
	if (submitForm_0 != "undefined" && submitForm_0 == true) {
		currForm.submit();
	}
	return true;
}

function performClientSideValidation(currForm) {
	var validationOK = true;
	var url = $(currForm).action;
    new Ajax.Request(
       url,
       {
    	   asynchronous: false,
           method: 'get',
           parameters: Form.serialize($(currForm)) + '&struts.enableJSONValidation=true&struts.validateOnly=true',
           onComplete: function(transport) {

      	   	 var form = $(currForm);
    	     //get errors from response
    	     var text = transport.responseText;
    	     var errorsObject = getValidationErrors(text);

    	     //show errors, if any
    	     if(errorsObject.fieldErrors) {
    	       validationOK = false;
    	       showValidationErrors(form, errorsObject);
    	     }
       	   }
       }
    );
	return validationOK;
}

function getValidationErrors(data) {
	  if(data.indexOf("/* {") == 0) {
	    return eval("( " + data.substring(2, data.length - 2) + " )");
	  } else {
	    return null;
	  }
}

function showValidationErrors(form, errors) {
	  var message = '';
	  if(errors.fieldErrors) {
	    for(var fieldName in errors.fieldErrors) {
	      for(var i = 0; i < errors.fieldErrors[fieldName].length; i++) {
	    	message = message + (errors.fieldErrors[fieldName][i]).strip() + "\n";
	      }
	    }
	  }
	  alert(message);
}


function findParentForm(element) {
	if (element == undefined) {
		return null;
	}
	var pa = element.parentNode;
	while (pa != null && pa.tagName.toLowerCase() != "form") {
		pa = pa.parentNode;
	}
	return pa;
}
/////////////////////////////////////////////////////////////
/////// DATA GRID SUPPORT CODE BEINGS
///////////////////////////////////////
var selectedGridRow;
function setSelectedGridRow(evtObj, indexHolderElement, indexValue) {
	clearRadioButtons();
	var parentRow = $(evtObj).up("tr");
	highlightRowPermanently(parentRow);
	selectedGridRow = parentRow;
	if (evtObj.tagName=='INPUT') {
		evtObj.checked = true;
	}
	if (indexHolderElement && indexValue) {
		$(indexHolderElement).value = parseInt(indexValue);
	}
	return true;
}
function highlightRowPermanently(trRow) {
	if (selectedGridRow != null) {
		selectedGridRow.className = "GridRow";
	}
	trRow.className = "HighlightGridRow";
}
function clearRadioButtons() {
	var selectedButton = findSelectedButton();
	var index = 0;
	while (selectedButton != null && (index < 1000)) {
		selectedButton.checked = false;
		selectedButton = findSelectedButton();
		index++;
	}
}
function findSelectedButton() {
	var inputs;
	var found;
	var index;
	var foundInput = null;
	inputs = document.forms[0].getElementsByTagName("INPUT");
	index = 0;
	while ((foundInput == null) && (index < inputs.length)) {
		if ((inputs[index].getAttribute("type") == "radio") && (inputs[index].checked)) {
			foundInput = inputs[index];
		}
		index++;
	}
	return foundInput;
}

/////////////////////////////////////////////////////////////
/////// DATA GRID SUPPORT CODE ENDS
///////////////////////////////////////

// Reports

function runReport(reportActionName, radioButtonEl) {
	var url = reportActionName+'!doCreateReport.action?reportType='+radioButtonEl.value;
	$('ReportOutputFrame').src=url;
}

var months=['January','February','March','April','May','June','July','August','September','October','November','December'];

function populateDateDropdowns(dayfield, monthfield, yearfield){
  var dayfield=document.getElementById(dayfield);
  var monthfield=document.getElementById(monthfield);
  var yearfield=document.getElementById(yearfield);
  var today=new Date();

  var month = document.getElementById("hiddenMonth").value;
  var day = document.getElementById("hiddenDay").value;
  var year = document.getElementById("hiddenYear").value;

  dayfield.options[0]=new Option("Day", "", true, true);
  for (var d=1; d <= 31; d++)
    dayfield.options[d]=new Option(d, d);

  if( day != null && day != "" ){
	dayfield.options[day].selected = "1";
  }

  monthfield.options[0]=new Option("Month", "", true, true);
  for (var m=1; m<=12; m++)
    monthfield.options[m]=new Option(months[m-1], m);

  if( month != null && month != "" ){
	monthfield.options[month].selected = "1";
  }

  yearfield.options[0]=new Option("Year", "", true, true);
  var thisyear=today.getFullYear();

  for (var y=1; y<120; y++){
    yearfield.options[y]=new Option(thisyear, thisyear);
    thisyear-=1;
  }

  thisyear = today.getFullYear() - year;
  if( year != null && year != "" ){
	yearfield.options[thisyear+1].selected = "1";
  }
}

function setDate(dateField, dayfield, monthfield, yearfield){
  var dayValue = document.getElementById(dayfield).value;
  var monthValue = document.getElementById(monthfield).value;
  var yearValue = document.getElementById(yearfield).value;
  if(dayValue<10)
    dayValue = "0"+dayValue;
  if(monthValue<10)
    monthValue = "0"+monthValue;

  document.getElementById(dateField).value = monthValue+"/"+dayValue+"/"+yearValue;
}