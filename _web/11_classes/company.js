class Employee {
    #id;
    #name = 'Anonymous';
    #title;
    #salary;
    #titles = ['programmer', 'developer', 'manager', 'cleaner', 'engineer'];

    constructor(id, name, title, salary) {
        this.#id = id;
        this.setName(name);
        this.setTitle(title);
        this.setSalary(salary);
    }

    getId() {
        return this.#id;
    }

    getName() {
        return this.#name;
    }

    setName(name) {
        if (name && typeof name === 'string') {
            this.#name = name;
        }
    }

    getTitle() {
        return this.#title;
    }

    setTitle(title) {
        if (title && this.#titles.includes(title)) {
            this.#title = title;
        }
    }

    getSalary() {
        return this.#salary;
    }

    setSalary(salary) {
        if (typeof salary == 'number' && salary >= 5000) {
            this.#salary = salary;
        }
    }
}

class Company {
    #employees = [];

    hireEmployee(employee) {

        if (!this.#employees.some(function (e) {
            return e.getId() === employee.getId();
        })) this.#employees.push(employee);
    }

    fireEmployee(id) {
        let index = this.#employees.findIndex(function (e) {
            return e.getId() === id;
        })
        return index >= 0 ? this.#employees.splice(index, 1) : null;
    }

    getEmployees() {
        return [...this.#employees];
    }

    getAllEmployees() {
        return [...this.#employees];
    }

    getEmployee(id) {
        return this.#employees.find(function (e) {
            return e.getId() === id;
        })
    }

    getCompanySize() {
        return this.#employees.length;
    }

    getTotalSalary() {
        return this.#employees.reduce(function (total, employee) {
            return total + employee.getSalary();
        }, 0);
    }

    getEmployeeMinSalary() {
        return Math.min(...this.#employees.map(function (e) {
            return e.getSalary();
        }))
    }

    greeting(greeting) {
        console.log(greeting + ' ' + this.name);
    }

    getEmployeesWithSalaryGreaterThan(salary) {
        return this.#employees.filter(function (e) {
            return e.getSalary() > salary;
        })
    }
}