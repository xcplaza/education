(
    function () {
        let App = window.App || {};

        function Orders() {
            this.data = {};
        }

        Orders.prototype.add = function (order) {
            if (!order.email) {
                throw new Error('Property email must be in order')
            }
            if (this.data[order.email])
                return `Order with email ${order.email} is already exists`;
            this.data[order.email] = order;
            return '';
        };

        Orders.prototype.remove = function (email) {
            if (!this.data[email]) {
                return false;
            }
            delete this.data[email];
            return '';
        }

        Orders.prototype.getAll = function ()
        {
            return Object.values(this.data);
        }

        Orders.prototype.get = function (email)
        {
            return this.data[email];
        }

        App.Orders = Orders;
        window.App = App;
    }
)()
// order = {name, size, email, .....}
// data = {email: {name, size, email, .....}}, {email: {name, size, email, .....}}