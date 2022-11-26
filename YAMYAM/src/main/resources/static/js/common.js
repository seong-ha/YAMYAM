
	// 공통 함수(js)
	function getTodayStr() {	
		let today = new Date(); 
		today = today.getFullYear() +"-" + ("00"+ (today.getMonth()+1)).slice(-2) +"-" + ("00"+ today.getDate()).slice(-2)
		return today;
	}
	
	function getTimeStr(){
		let today = new Date();
		today = today.getFullYear() +"-" + ("00"+ (today.getMonth()+1)).slice(-2) +"-" + ("00"+ today.getDate()).slice(-2)+" "+
		('0' + today.getHours()).slice(-2) + ":" +  ('0'+today.getMinutes()).slice(-2) + ":" + ('0'+today.getSeconds()).slice(-2);
		return today;
	}
	
	function getToday() {	
		let today = new Date(); 
		return today;
	}		
	
	
	function addDay(y,m,d) {	
		let today = new Date(); 
		today.setFullYear(today.getFullYear()+y)
		return today;
	}	
	
	
	/*------------
	@param rangel : getToday()[오늘부터], 0[range를 정하지않음]
	-------------*/
	function pickerInit(targetel, inputel, rangel){
		if(!rangel){
			rangel = 0;
		} 
		return new tui.DatePicker(targetel, {
			date : new Date(),
			input : {
				element : inputel,
				format : 'yyyy-MM-dd'
			},
			selectableRanges : [[rangel,addDay(1)]],
			language: 'ko'
		}); 	
	}
	
	
	function rangeDatepickerInit(sdt, sdtcont, edt, edtcont){
	 return	tui.DatePicker.createRangePicker({
			startpicker : {
				date : getToday(),
				input : sdt,
				container : sdtcont
			},
			endpicker : {
				date : getToday(),
				input : edt,
				container : edtcont
			},
			selectableRanges : [ [
					0,
					addDay(1) ] ],
			language: 'ko'
		});
	}
	
	let today = getTodayStr();
	
	var Grid = tui.Grid;
	Grid.setLanguage('ko');
	
	
	/*------------
	// sweetAlert2 - confirm
	@param msg='C/R/U/D'
		   callBack = { // 모르겠으면 호출하세요
		   Swal.fire('삭제/완료,수정가 완료되었습니다')};
	----------------*/
	
	 function sweetConfirm(msg, callBack){
		let msgA = {'C':'등록','R':'조회','U':'수정','D':'삭제'}

		 Swal.fire({
		      title: `정말로 ${msgA[msg]} 하시겠습니까?`,
		      icon: 'warning',
		      showCancelButton: true,
		      confirmButtonColor: '#3085d6',
		      cancelButtonColor: '#d33',
		      confirmButtonText: '승인',
		      cancelButtonText: '취소'
		      
		    }).then((result) => {
		    if(result.isConfirmed){
		     	callBack();
		    }
		     
		     })
		     
	}
