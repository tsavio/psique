export class RequestResult {

    constructor(private success: boolean,
        private response?: any) {
    }

    public isSuccess(): boolean {
        return this.success;
    }

    public isFailed(): boolean {
        return !this.success;
    }

    public getResponse(): any {
        return this.response;
    }
}