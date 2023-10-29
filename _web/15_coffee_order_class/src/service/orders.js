export default class Orders {
    #data;

    constructor() {
        this.#data = {};
    }

    add = order => {
        if (!order.email) {
            throw new Error('Property email must be in order')
        }
        if (this.#data[order.email])
            return `Order with email ${order.email} is already exists`;
        this.#data[order.email] = order;
        return '';
    }

    remove = email => {
        if (!this.#data[email]) {
            return false;
        }
        delete this.#data[email];
        return '';
    }

    getAll = () => {
        return Object.values(this.#data);
    }

    get = email => {
        return this.#data[email];
    }
}
// order = {name, size, email, .....}
// data = {email: {name, size, email, .....}}, {email: {name, size, email, .....}}