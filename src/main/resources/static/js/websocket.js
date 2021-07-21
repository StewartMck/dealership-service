(() => {
    const socket = new SockJS('/update');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/status/update', function (update) {
        console.log('receiving')
            const data = JSON.parse(update.body)
            if (!data.registration) {
                return;
            } else {
            const dataExists = checkData(data.registration);
            if (!dataExists) {
                addData(data)
            } else {
                updateData(dataExists, data)
            }
            }
        });
    });
})();

document.getElementById("submit").addEventListener('click', (event)=>{
    stompClient.send("/app/update", {},
                      JSON.stringify(getDataFromForm()));

})

function getDataFromForm() {
    const data = document.getElementsByClassName("data")[0];
    const registration = data.querySelector("#registration").value;
    const model = data.querySelector("#model").value;
    const customer = data.querySelector("#customer").value;
    const status = data.querySelector("#status").value;
    return {registration, model, customer, status}
}

function addData({registration, customer, model, status}) {

    const newRow = `<tr id="service-data">
                            <td id="vehicle-reg">

                            </td>
                            <td id="vehicle-model">${model}</td>
                            <td id="vehicle-customer">${customer}</td>
                            <td id="vehicle-status" color-id=${status}>${status}</td>
                            <td id="service-advisor">Amanda</td>
                          </tr>`
    $('#vehicle-reg').append(`<a id="vehicle-reg-href" href="/service/item?id=${registration}">${registration}</a>`)
    const table = document.getElementsByClassName("vehicles")[0];
    console.log($('.vehicles > tbody tr:last'))
    $('.vehicles > tbody').append(newRow)
}

function checkData(reg) {
    console.log('reg:', reg)
    const rows = $("tr").not(":first");
    for(const row of rows) {
        const data = $(row).find("#vehicle-reg");
        if(data.text() === reg) {
            return row;
        }
    }
    return undefined;
}

function updateData(element, {registration, model, customer, status}) {
    $(element).find("#vehicle-reg").text(registration);
    $(element).find("#vehicle-model").text(model);
    $(element).find("#vehicle-customer").text(customer);
    $(element).find("#vehicle-status").text(status);
    $(element).find("#vehicle-status").attr( "color-id", status )
}