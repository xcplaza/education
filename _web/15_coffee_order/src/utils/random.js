(
    function () {
        let App = window.App || {};

        function Random() {
        }

        Random.prototype.getRandomNumber = function (min, max) {
            if (min >= max) {
                throw new Error('min must be less than max');
            }
            return min + Math.round(Math.random() * (max - min));
        };

        Random.prototype.getRandomElement = function (array) {
            return array[this.getRandomNumber(0, array.length - 1)];
        }
        App.Random = Random;
        Window.App = App;
    }
)()