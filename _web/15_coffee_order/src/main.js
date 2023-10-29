(function () {
    let App = window.App;
    const orders = new App.Orders();
    const random = new App.Random();
    const gen = new App.OrderGenerator(random);
    const N_ORDERS = 10;
    for (let i = 0; i < N_ORDERS; i++) {
        orders.add(gen.getRandomOrder());
    }
    const list = new App.List('ol');
    orders.getAll().forEach(function (order) {
        list.addItem(JSON.stringify(order));
    })
})()

// Ui
// Service
// Config
// Utils
// Controller