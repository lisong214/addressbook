function myFunction() {
	
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("Addresstable");
  tr = table.getElementsByTagName("tr");
  
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[1];
	td1 = tr[i].getElementsByTagName("td")[2];
	td2 = tr[i].getElementsByTagName("td")[3];
	td3 = tr[i].getElementsByTagName("td")[5];
	td4 = tr[i].getElementsByTagName("td")[7];
	td5 = tr[i].getElementsByTagName("td")[8];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1||td1.innerHTML.toUpperCase().indexOf(filter) > -1||td2.innerHTML.toUpperCase().indexOf(filter) > -1||td3.innerHTML.toUpperCase().indexOf(filter) > -1||td4.innerHTML.toUpperCase().indexOf(filter) > -1||td5.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    } 
  }
}