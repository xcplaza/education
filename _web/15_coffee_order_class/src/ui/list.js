export default class List {
    #listElements;

    constructor(selector) {
        this.#listElements = document.querySelector(selector);
    }

    addItem(string) {
        let element = document.createElement('li');
        element.textContent = string;
        this.#listElements.append(element);
    }
}

// (function () {
//     let App = window.App || {};
//
//     function List(selector) {
//         this.listElements = document.querySelector(selector);
//     }
//
//     List.prototype.addItem = function (string) {
//         let element = document.createElement('li');
//         element.textContent = string;
//         this.listElements.append(element);
//     }
//     App.List = List;
//     window.App = App;
// })()