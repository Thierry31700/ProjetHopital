export class ServiceDp {

    private _id: number;
    private _libelle: string;
    

	constructor(id: number, libelle: string) {
		this._id = id;
		this._libelle = libelle;
	}

    /**
     * Getter $id
     * @return {number}
     */
	public get id(): number {
		return this._id;
	}

    /**
     * Getter $libelle
     * @return {string}
     */
	public get libelle(): string {
		return this._libelle;
	}

    /**
     * Setter $id
     * @param {number} value
     */
	public set id(value: number) {
		this._id = value;
	}

    /**
     * Setter $libelle
     * @param {string} value
     */
	public set libelle(value: string) {
		this._libelle = value;
	}
    
    }

