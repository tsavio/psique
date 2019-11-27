
class Consultation {

    constructor(data) {
        this.url= "https://hangouts.google.com/hangouts/_/raaystieqjdojcqw26iapnwjvye";
        this.anamnese = "Vazio";
        this.date = data.date;
        this.deleted = false;
        this.doctorId = data.doctorId;
        this.doctorName = data.doctorName;
        this.hour = data.hour;
        this.patientId = data.patientId;
        this.patientName = data.patientName;
    }
}

module.exports = Consultation;