/*
 * ATTENTION: The "eval" devtool has been used (maybe by default in mode: "development").
 * This devtool is neither made for production nor for readable output files.
 * It uses "eval()" calls to create a separate source file in the browser devtools.
 * If you are trying to read the output file, select a different devtool (https://webpack.js.org/configuration/devtool/)
 * or disable the default devtool with "devtool: false".
 * If you are looking for production-ready output files, see mode: "production" (https://webpack.js.org/configuration/mode/).
 */
/******/ (() => { // webpackBootstrap
/******/ 	"use strict";
/******/ 	var __webpack_modules__ = ({

/***/ "./src/config/constants.js":
/*!*********************************!*\
  !*** ./src/config/constants.js ***!
  \*********************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export */ __webpack_require__.d(__webpack_exports__, {\n/* harmony export */   coffeeNames: () => (/* binding */ coffeeNames),\n/* harmony export */   ed: () => (/* binding */ emailDomains),\n/* harmony export */   flavor: () => (/* binding */ flavor),\n/* harmony export */   size: () => (/* binding */ size)\n/* harmony export */ });\nconst coffeeNames = ['cappuccino', 'latte', 'espresso', 'americano', 'afuh'];\nconst size = ['small', 'normal', 'big'];\nconst flavor = ['milk', 'sugar', 'cardamon', 'chocolate', 'cinnamon', 'cognac', 'vanilla'];\nconst emailDomains = ['gmail.com', 'yandex.ru', 'hotmail.com', 'mail.ru', 'yahoo.com'];\n\n\n\n//# sourceURL=webpack://15_coffee_order_class/./src/config/constants.js?");

/***/ }),

/***/ "./src/main.js":
/*!*********************!*\
  !*** ./src/main.js ***!
  \*********************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

eval("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var _service_orders__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./service/orders */ \"./src/service/orders.js\");\n/* harmony import */ var _utils_random__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./utils/random */ \"./src/utils/random.js\");\n/* harmony import */ var _service_orderGenerator__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./service/orderGenerator */ \"./src/service/orderGenerator.js\");\n/* harmony import */ var _ui_list__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./ui/list */ \"./src/ui/list.js\");\n\n\n\n\n\nconst orders = new _service_orders__WEBPACK_IMPORTED_MODULE_0__[\"default\"]();\nconst random = new _utils_random__WEBPACK_IMPORTED_MODULE_1__[\"default\"]();\nconst gen = new _service_orderGenerator__WEBPACK_IMPORTED_MODULE_2__[\"default\"](random);\nconst list = new _ui_list__WEBPACK_IMPORTED_MODULE_3__[\"default\"]('ol');\n\nconst N_ORDERS = 10;\nfor (let i = 0; i < N_ORDERS; i++) {\n    orders.add(gen.getRandomOrder());\n}\norders.getAll().forEach(function (order) {\n    list.addItem(JSON.stringify(order));\n});\n\n//# sourceURL=webpack://15_coffee_order_class/./src/main.js?");

/***/ }),

/***/ "./src/service/orderGenerator.js":
/*!***************************************!*\
  !*** ./src/service/orderGenerator.js ***!
  \***************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export */ __webpack_require__.d(__webpack_exports__, {\n/* harmony export */   \"default\": () => (__WEBPACK_DEFAULT_EXPORT__)\n/* harmony export */ });\n/* harmony import */ var _config_constants__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../config/constants */ \"./src/config/constants.js\");\n\n\nclass OrderGenerator {\n    #random;\n\n    constructor(random) {\n        this.#random = random;\n    }\n\n    getRandomOrder = () => {\n        return {\n            coffee: this.#random.getRandomElement(_config_constants__WEBPACK_IMPORTED_MODULE_0__.coffeeNames),\n            email: 'name' + this.#random.getRandomNumber(0, 1000) + '@' + this.#random.getRandomElement(_config_constants__WEBPACK_IMPORTED_MODULE_0__.ed),\n            size: this.#random.getRandomElement(_config_constants__WEBPACK_IMPORTED_MODULE_0__.size),\n            flavor: this.#random.getRandomElement(_config_constants__WEBPACK_IMPORTED_MODULE_0__.flavor),\n            strength: this.#random.getRandomNumber(1, 100)\n        };\n    }\n}\n/* harmony default export */ const __WEBPACK_DEFAULT_EXPORT__ = (OrderGenerator);\n\n//# sourceURL=webpack://15_coffee_order_class/./src/service/orderGenerator.js?");

/***/ }),

/***/ "./src/service/orders.js":
/*!*******************************!*\
  !*** ./src/service/orders.js ***!
  \*******************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export */ __webpack_require__.d(__webpack_exports__, {\n/* harmony export */   \"default\": () => (/* binding */ Orders)\n/* harmony export */ });\nclass Orders {\n    #data;\n\n    constructor() {\n        this.#data = {};\n    }\n\n    add = order => {\n        if (!order.email) {\n            throw new Error('Property email must be in order')\n        }\n        if (this.#data[order.email])\n            return `Order with email ${order.email} is already exists`;\n        this.#data[order.email] = order;\n        return '';\n    }\n\n    remove = email => {\n        if (!this.#data[email]) {\n            return false;\n        }\n        delete this.#data[email];\n        return '';\n    }\n\n    getAll = () => {\n        return Object.values(this.#data);\n    }\n\n    get = email => {\n        return this.#data[email];\n    }\n}\n// order = {name, size, email, .....}\n// data = {email: {name, size, email, .....}}, {email: {name, size, email, .....}}\n\n//# sourceURL=webpack://15_coffee_order_class/./src/service/orders.js?");

/***/ }),

/***/ "./src/ui/list.js":
/*!************************!*\
  !*** ./src/ui/list.js ***!
  \************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export */ __webpack_require__.d(__webpack_exports__, {\n/* harmony export */   \"default\": () => (/* binding */ List)\n/* harmony export */ });\nclass List {\n    #listElements;\n\n    constructor(selector) {\n        this.#listElements = document.querySelector(selector);\n    }\n\n    addItem(string) {\n        let element = document.createElement('li');\n        element.textContent = string;\n        this.#listElements.append(element);\n    }\n}\n\n// (function () {\n//     let App = window.App || {};\n//\n//     function List(selector) {\n//         this.listElements = document.querySelector(selector);\n//     }\n//\n//     List.prototype.addItem = function (string) {\n//         let element = document.createElement('li');\n//         element.textContent = string;\n//         this.listElements.append(element);\n//     }\n//     App.List = List;\n//     window.App = App;\n// })()\n\n//# sourceURL=webpack://15_coffee_order_class/./src/ui/list.js?");

/***/ }),

/***/ "./src/utils/random.js":
/*!*****************************!*\
  !*** ./src/utils/random.js ***!
  \*****************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export */ __webpack_require__.d(__webpack_exports__, {\n/* harmony export */   \"default\": () => (/* binding */ Random)\n/* harmony export */ });\nclass Random {\n    getRandomNumber = (min, max) => {\n        if (min >= max) {\n            throw new Error('min must be less than max');\n        }\n        return min + Math.round(Math.random() * (max - min));\n    };\n\n    getRandomElement = (array) => {\n        return array[this.getRandomNumber(0, array.length - 1)];\n    }\n}\n\n// (\n//     function () {\n//         let App = window.App || {};\n//\n//         function Random() {\n//         }\n//\n//         Random.prototype.getRandomNumber = function (min, max) {\n//             if (min >= max) {\n//                 throw new Error('min must be less than max');\n//             }\n//             return min + Math.round(Math.random() * (max - min));\n//         };\n//\n//         Random.prototype.getRandomElement = function (array) {\n//             return array[this.getRandomNumber(0, array.length - 1)];\n//         }\n//         App.Random = Random;\n//         Window.App = App;\n//     }\n// )()\n\n//# sourceURL=webpack://15_coffee_order_class/./src/utils/random.js?");

/***/ })

/******/ 	});
/************************************************************************/
/******/ 	// The module cache
/******/ 	var __webpack_module_cache__ = {};
/******/ 	
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/ 		// Check if module is in cache
/******/ 		var cachedModule = __webpack_module_cache__[moduleId];
/******/ 		if (cachedModule !== undefined) {
/******/ 			return cachedModule.exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = __webpack_module_cache__[moduleId] = {
/******/ 			// no module.id needed
/******/ 			// no module.loaded needed
/******/ 			exports: {}
/******/ 		};
/******/ 	
/******/ 		// Execute the module function
/******/ 		__webpack_modules__[moduleId](module, module.exports, __webpack_require__);
/******/ 	
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/ 	
/************************************************************************/
/******/ 	/* webpack/runtime/define property getters */
/******/ 	(() => {
/******/ 		// define getter functions for harmony exports
/******/ 		__webpack_require__.d = (exports, definition) => {
/******/ 			for(var key in definition) {
/******/ 				if(__webpack_require__.o(definition, key) && !__webpack_require__.o(exports, key)) {
/******/ 					Object.defineProperty(exports, key, { enumerable: true, get: definition[key] });
/******/ 				}
/******/ 			}
/******/ 		};
/******/ 	})();
/******/ 	
/******/ 	/* webpack/runtime/hasOwnProperty shorthand */
/******/ 	(() => {
/******/ 		__webpack_require__.o = (obj, prop) => (Object.prototype.hasOwnProperty.call(obj, prop))
/******/ 	})();
/******/ 	
/******/ 	/* webpack/runtime/make namespace object */
/******/ 	(() => {
/******/ 		// define __esModule on exports
/******/ 		__webpack_require__.r = (exports) => {
/******/ 			if(typeof Symbol !== 'undefined' && Symbol.toStringTag) {
/******/ 				Object.defineProperty(exports, Symbol.toStringTag, { value: 'Module' });
/******/ 			}
/******/ 			Object.defineProperty(exports, '__esModule', { value: true });
/******/ 		};
/******/ 	})();
/******/ 	
/************************************************************************/
/******/ 	
/******/ 	// startup
/******/ 	// Load entry module and return exports
/******/ 	// This entry module can't be inlined because the eval devtool is used.
/******/ 	var __webpack_exports__ = __webpack_require__("./src/main.js");
/******/ 	
/******/ })()
;