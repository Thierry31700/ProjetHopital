import { Compte } from "./compte";
import { ServiceDp } from "./service-dp";

export class Employe {
    private _id: number;
    private _nom: string;
    private _prenom: string;

    private _manager: Employe;
    private _servicedp: ServiceDp;
    private _compte: Compte;

	constructor(id?: number, nom: string='', prenom: string='', manager?: Employe, servicedp?: ServiceDp, compte?: Compte) {
		this._id = id;
		this._nom = nom;
		this._prenom = prenom;
		this._manager = manager;
		this._servicedp = servicedp;
		this._compte = compte;
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
     * Getter servicedp
     * @return {ServiceDp}
     */
	public get servicedp(): ServiceDp {
		return this._servicedp;
	}

    /**
     * Getter compte
     * @return {Compte}
     */
	public get compte(): Compte {
		return this._compte;
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

    /**
     * Setter servicedp
     * @param {ServiceDp} value
     */
	public set servicedp(value: ServiceDp) {
		this._servicedp = value;
	}

    /**
     * Setter compte
     * @param {Compte} value
     */
	public set compte(value: Compte) {
		this._compte = value;
	}
	






}
