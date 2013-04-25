/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function applyAllFormats() {
  applyAllNumericFormats();  
  applyAllDateFormats();
}

function applyAllNumericFormats() {
 applyMoneyFormat();   
 applyIntegerFormat();
 applyNumericFormat();
 applySinglePrecisionFormat();
 applyDoublePrecisionFormat();
 applyTripplePrecisionFormat();
 applySmallDecimalFormat();
 applyFloatingPointFormat();
}




function applyMoneyFormat() {
  $('input.moneyType').each(
                        function(i,element) {  
                         var newValue = $.format.number(parseFloat(this.value), '#,###.##');
                         
                         this.value = '$ ' + newValue;
                        }
                       )  
}

function applyMoneyFormat2(id) {
  $('input#' + id).each(
                        function(i,element) {  
                         var newValue = $.format.number(parseFloat(this.value), '#,###.##');
                         
                         this.value = '$ ' + newValue;
                        }
                       )  
}

function applyIntegerFormat() {
  $('input.integerType').each(
                        function(i,element) {  
                         var newValue = $.format.number(parseInt(this.value), '######0');
                         
                         this.value = newValue;
                        }
                       )  
}

function applyIntegerFormat2(id) {
  $('input#' + id).each(
                        function(i,element) {  
                         var newValue = $.format.number(parseInt(this.value), '######0');
                         
                         this.value = newValue;
                        }
                       )  
}

function applyNumericFormat() {
  $('input.numericyType').each(
                        function(i,element) {  
                         var newValue = $.format.number(parseFloat(this.value), '#,###.##');
                         
                         this.value = newValue;
                        }
                       )  
}

function applyNumericFormat2(id) {
  $('input#' + id).each(
                        function(i,element) {  
                         var newValue = $.format.number(parseFloat(this.value), '#,###.##');
                         
                         this.value = newValue;
                        }
                       )  
}

function applySinglePrecisionFormat() {
  $('input.singlePrecisionType').each(
                        function(i,element) {  
                         var newValue = $.format.number(parseFloat(this.value), '#00.#');
                         
                         this.value = newValue;
                        }
                       )  
}

function applySinglePrecisionFormat2(id) {
  $('input#' + id).each(
                        function(i,element) {  
                         var newValue = $.format.number(parseFloat(this.value), '#00.#');
                         
                         this.value = newValue;
                        }
                       )  
}

function applyDoublePrecisionFormat() {
  $('input.doublePrecisionType').each(
                        function(i,element) {  
                         var newValue = $.format.number(parseFloat(this.value), '##0.00');
                         
                         this.value = newValue;
                        }
                       )  
}

function applyDoublePrecisionFormat2(id) {
  $('input#' + id).each(
                        function(i,element) {  
                         var newValue = $.format.number(parseFloat(this.value), '##0.00');
                         
                         this.value = newValue;
                        }
                       )  
}

function applyTripplePrecisionFormat() {
  $('input.tripplePrecisionType').each(
                        function(i,element) {  
                         var newValue = $.format.number(parseFloat(this.value), '#####.000');
                         
                         this.value = newValue;
                        }
                       )  
}

function applyTripplePrecisionFormat2(id) {
  $('input#' + id).each(
                        function(i,element) {  
                         var newValue = $.format.number(parseFloat(this.value), '#####.000');
                         
                         this.value = newValue;
                        }
                       )  
}

function applySmallDecimalFormat() {
  $('input.smallDecimalType').each(
                        function(i,element) {  
                         var newValue = $.format.number(parseFloat(this.value), '0.000000');
                         
                         this.value = newValue;
                        }
                       )  
}

function applySmallDecimalFormat2(id) {
  $('input#' + id).each(
                        function(i,element) {  
                         var newValue = $.format.number(parseFloat(this.value), '0.000000');
                         
                         this.value = newValue;
                        }
                       )  
}


function applyFloatingPointFormat() {
  $('input.floatingPointType').each(
                        function(i,element) {  
                         var newValue = $.format.number(parseFloat(this.value),'####0.0000');
                         
                         this.value = newValue;
                        }
                       )  
}


function applyFloatingPointFormat2(id) {
  $('input#' + id).each(
                        function(i,element) {  
                         var newValue = $.format.number(parseFloat(this.value),'####0.0000');
                         
                         this.value = newValue;
                        }
                       )  
}



function applyAllDateFormats() {
 applyDefaultDateFormat(); 
 applyISO8601DateFormat();  
 applyShortDateFormat();
 applyMediumDateFormat();
 applyFullDateFormat();
 applySentenceDateFormat();
 applyISO8601DateFormat3();
}

//$("#datepicker").datepicker();

function applyDefaultDateFormat() {
  $('input.defaultDateType').datepicker( "option", "dateFormat", "mm/dd/yy" );
}

function applyDefaultDateFormat(id) {
  $('input#' + id).datepicker( "option", "dateFormat", "mm/dd/yy" );
}

function applyISO8601DateFormat() {
  $('input.isoDateType').datepicker( "option", "dateFormat", "yy-mm-dd" );
}

function applyISO8601DateFormat3() {
  $('label.isoDateType').datepicker( "option", "dateFormat", "yy-mm-dd" );
}

function applyShortDateFormat() {
  $('input.shortDateType').datepicker( "option", "dateFormat", "d M, y");
}

function applyMediumDateFormat() {
  $('input.mediumDateType').datepicker( "option", "dateFormat", "d MM, y");
}


function applyFullDateFormat() {
  $('input.fullDateType').datepicker( "option", "dateFormat", "DD, d MM, yy");
}

function applySentenceDateFormat() {
  $('input.sentenceDateType').datepicker( "option", "dateFormat","'day' d 'of' MM 'in the year' yy");
}