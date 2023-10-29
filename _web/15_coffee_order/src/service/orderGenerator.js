// coffee:
// email
// size
// flavor
// strength

(function () {
    let App = window.App || {};

    function OrderGenerator(random) {
        this.random = random;
    }

    OrderGenerator.prototype.getRandomOrder = function () {
        return {
            coffee: this.random.getRandomElement(coffeeNames),
            email: 'name' + this.random.getRandomNumber(0, 1000) + '@' + this.random.getRandomElement(emailDomains),
            size: this.random.getRandomElement(size),
            flavor: this.random.getRandomElement(flavor),
            strength: this.random.getRandomNumber(1, 100)
        };
    }
    App.OrderGenerator = OrderGenerator;
    window.App = App;
})
()