export class Login {
    private _mail: string;
    private _password: string;


	constructor(mail: string= '', password: string= '') {
		this._mail = mail;
		this._password = password;
	}

    /**
     * Getter mail
     * @return {string}
     */
	public get mail(): string {
		return this._mail;
	}

    /**
     * Getter password
     * @return {string}
     */
	public get password(): string {
		return this._password;
	}

    /**
     * Setter mail
     * @param {string} value
     */
	public set mail(value: string) {
		this._mail = value;
	}

    /**
     * Setter password
     * @param {string} value
     */
	public set password(value: string) {
		this._password = value;
	}

}
