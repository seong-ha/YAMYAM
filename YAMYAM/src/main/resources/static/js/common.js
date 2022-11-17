
	// 공통 함수(js)
	function getTodayStr() {	
		let today = new Date(); 
		today = today.getFullYear() +"-" + ("00"+ (today.getMonth()+1)).slice(-2) +"-" + ("00"+ today.getDate()).slice(-2)
		return today;
	}
		
	function getToday() {	
		const today = new Date(); 
		return today;
	}		
	
	
	function addDay(y,m,d) {	
		let today = new Date(); 
		today.setFullYear(today.getFullYear()+y)
		return today;
	}	
	
	
	function pickerInit(targetel, inputel){
		return new tui.DatePicker(targetel, {
			date : new Date(),
			input : {
				element : inputel,
				format : 'yyyy-MM-dd'
			},
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
					getToday(),
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
		      cancelButtonText: '취소',
		      //reverseButtons: true, // 버튼 순서 거꾸로
		      
		    }).then((result) => {
		    if(result.isConfirmed){
		     	callBack();
		    }
		     
		     })
		     
	}
