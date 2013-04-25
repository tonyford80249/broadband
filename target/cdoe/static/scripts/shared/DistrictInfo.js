$(document).ready(function() {
		/*
		 *  Attached function to dropdown's onchange event.
		 */
		$('#districtCodeList').change(function() {
			var varDistrictNumber = $('#districtCodeList option:selected').val();
			$.ajax({
				type: "GET",
				url: "${pageContext.request.contextPath}/secure/Ajax/lookup/" + varDistrictNumber,
				async:false,
				success:function(result) {
					$('#districtNameField').val(result);
				}
			});
		 });
		});