export class Compte {
    private id: number;
    private _mail: string;
    private _password: string;


	constructor($id: number, mail: string, password: string) {
		this.id = $id;
		this._mail = mail;
		this._password = password;
	}

    /**
     * Getter $id
     * @return {number}
     */
	public get $id(): number {
		return this.id;
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
     * Setter $id
     * @param {number} value
     */
	public set $id(value: number) {
		this.id = value;
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
