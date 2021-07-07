// constants
const expandButton = document.getElementById("expand");
const table = document.getElementsByClassName("vehicles")[0];
const edit = document.getElementsByClassName("edit-container")[0];
const newNote = document.getElementById("new-note");

expandButton.addEventListener("click", ()=>{
    if(expandButton.getAttribute("data_expanded") === 'false') {
        table.style.display = "none";
        edit.style.width = "80%";
        expandButton.setAttribute("data_expanded", true);
        newNote.style.display = "flex";
    } else {
        table.style.display = "table";
        edit.style.width = "30%";
        expandButton.setAttribute("data_expanded", false);
        newNote.style.display = "none";
    }

})