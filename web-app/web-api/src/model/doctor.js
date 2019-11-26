
class Doctor {
    // private id;
    // name;
    // cpf;
    // email;
    // phone;
    // deleted;
    // avaliation;
    // crp;

    constructor(data) {
        this.name = data.name;
        this.cpf = data.cpf;
        this.email = data.email;
        this.passworrd = data.password;
        this.specialty = data.specialty;

        this.phone = data.phone;
        this.crp = data.crp;
        this.deleted = false;
        this.avaliation = 0;
    }
}

module.exports = Doctor;