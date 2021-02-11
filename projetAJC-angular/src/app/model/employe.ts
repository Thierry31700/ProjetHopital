export class Employe {
    private _id: number;
    private _nom: string;
    private _prenom: string;

    private _manager: Employe;


	constructor(id?: number, nom: string='', prenom: string='', manager?: Employe) {
		this._id = id;
		this._nom = nom;
		this._prenom = prenom;
		this._manager = manager;
	}

    /**
     * Getter id
     * @return {number}
     */
	public get id(): number {
		return this._id;
	}

    /**
     * Getter nom
     * @return {string}
     */
	public get nom(): string {
		return this._nom;
	}

    /**
     * Getter prenom
     * @return {string}
     */
	public get prenom(): string {
		return this._prenom;
	}

    /**
     * Getter manager
     * @return {Employe}
     */
	public get manager(): Employe {
		return this._manager;
	}

    /**
     * Setter id
     * @param {number} value
     */
	public set id(value: number) {
		this._id = value;
	}

    /**
     * Setter nom
     * @param {string} value
     */
	public set nom(value: string) {
		this._nom = value;
	}

    /**
     * Setter prenom
     * @param {string} value
     */
	public set prenom(value: string) {
		this._prenom = value;
	}

    /**
     * Setter manager
     * @param {Employe} value
     */
	public set manager(value: Employe) {
		this._manager = value;
	}

    
}
