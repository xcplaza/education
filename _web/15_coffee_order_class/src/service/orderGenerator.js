import {coffeeNames, ed, size, flavor} from "../config/constants";

class OrderGenerator {
    #random;

    constructor(random) {
        this.#random = random;
    }

    getRandomOrder = () => {
        return {
            coffee: this.#random.getRandomElement(coffeeNames),
            email: 'name' + this.#random.getRandomNumber(0, 1000) + '@' + this.#random.getRandomElement(ed),
            size: this.#random.getRandomElement(size),
            flavor: this.#random.getRandomElement(flavor),
            strength: this.#random.getRandomNumber(1, 100)
        };
    }
}
export default OrderGenerator;