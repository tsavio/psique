
class AvailabilityTime {

    constructor(data) {
        this.hour = data.hour;
        this.date = data.date;
        this.doctorId = data.userId;
        this.doctorName = data.doctorName;
        this.using = false;
    }
}

module.exports = AvailabilityTime;