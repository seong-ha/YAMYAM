
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
	