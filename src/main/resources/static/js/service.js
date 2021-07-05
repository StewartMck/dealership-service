document.getElementById("clear").addEventListener("click", ()=>{
    const editContainer = document.getElementsByClassName("data")[0];
    const elements = editContainer.querySelectorAll("input, textarea");

    elements.forEach((element)=>{
       element.value="";
    })

    const statusMessage = document.getElementById("status");
    statusMessage.value="QUEUE"

})