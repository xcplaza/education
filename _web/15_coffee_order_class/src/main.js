import Orders from "./service/orders";
import Random from "./utils/random";
import OrderGenerator from "./service/orderGenerator";
import List from "./ui/list";

const orders = new Orders();
const random = new Random();
const gen = new OrderGenerator(random);
const list = new List('ol');

const N_ORDERS = 10;
for (let i = 0; i < N_ORDERS; i++) {
    orders.add(gen.getRandomOrder());
}
orders.getAll().forEach(function (order) {
    list.addItem(JSON.stringify(order));
});