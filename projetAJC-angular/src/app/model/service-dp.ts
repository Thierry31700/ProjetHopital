export class ServiceDp {

    private id: number;
    private libelle: string;
    

	constructor($id: number, $libelle: string) {
		this.id = $id;
		this.libelle = $libelle;
	}

    /**
     * Getter $id
     * @return {number}
     */
	public get $id(): number {
		return this.id;
	}

    /**
     * Getter $libelle
     * @return {string}
     */
	public get $libelle(): string {
		return this.libelle;
	}

    /**
     * Setter $id
     * @param {number} value
     */
	public set $id(value: number) {
		this.id = value;
	}

    /**
     * Setter $libelle
     * @param {string} value
     */
	public set $libelle(value: string) {
		this.libelle = value;
	}
    
    }

