(() => {
    var socket = new SockJS('/update');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/status/update', function (update) {
        console.log('receiving')
//            console.log(JSON.parse(update.body).content);
              console.log(update.body);
        });
    });
})();

document.getElementById("submit").addEventListener('click', (event)=>{
event.preventDefault()
    stompClient.send("/app/update", {},
                      JSON.stringify({'from':"service", 'text':"Submit clicked"}));
})

function setConnected(connected) {
    console.log("Connected:", connected)
}
//
//function sendMessage() {
//
//}