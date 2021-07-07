// constants
const expandButton = document.getElementById("expand");
const table = document.getElementsByClassName("vehicles")[0];
const edit = document.getElementsByClassName("edit-container")[0];
const newNoteContainer = document.getElementById("new-note");

expandButton.addEventListener("click", ()=>{
    if(expandButton.getAttribute("data_expanded") === 'false') {
        table.style.display = "none";
        edit.style.width = "80%";
        expandButton.setAttribute("data_expanded", true);
        newNoteContainer.style.display = "flex";
    } else {
        table.style.display = "table";
        edit.style.width = "30%";
        expandButton.setAttribute("data_expanded", false);
        newNoteContainer.style.display = "none";
    }

})

const newNoteButton = newNoteContainer.querySelector("button")

newNoteButton.addEventListener("click", ()=> {
    const newNote= newNoteContainer.querySelector("input").value;
    const workshopNotes = edit.querySelector("#workshop");
    workshopNotes.value += `[${new Date().toLocaleString()}]: ${newNote}\n`;
    })


