
public class Persona {
	private String nameSurname;
	private int yearOfBirth;

	/**
	 * Constructor for Person
	 * 
	 * @param Name
	 *            and surname
	 * @param Year
	 *            of birth
	 */
	public Persona(String nameSurname, int yearOfBirth) {
		super();
		this.nameSurname = nameSurname;
		this.yearOfBirth = yearOfBirth;
	}

	/**
	 * Constructor for Person with year as a string
	 * 
	 * @param Name
	 *            and surname
	 * @param Year
	 *            of birth
	 */
	public Persona(String nameSurname, String yearOfBirth) {
		this(nameSurname, Integer.parseInt(yearOfBirth));
	}

	/**
	 * Getter for name and surname
	 * 
	 * @return Name and surname
	 */
	public String getNameSurname() {
		return nameSurname;
	}

	/**
	 * Getter for year of birth
	 * 
	 * @return Year of birth
	 */
	public int getYearOfBirth() {
		return yearOfBirth;
	}

	/**
	 * Check the names of 2 persons
	 * 
	 * @param Another
	 *            person
	 * @return True if both persons have the same name, false otherwise
	 */
	public boolean omonimo(Persona p) {
		return this.nameSurname.equalsIgnoreCase(p.getNameSurname());
	}

	/**
	 * Checks which one of 2 persons is older
	 * 
	 * @param Another
	 *            person
	 * @return 1 if the current Person is younger, 0 if both have the same year of
	 *         birth, -1 if the current person is older
	 */
	public int isOlder(Persona that) {
		int result = this.getYearOfBirth() - that.getYearOfBirth();
		return (result < 0 ? -1 : (result == 0) ? 0 : 1);
	}

	/**
	 * Checks if the current person is older than everyone in the array
	 * 
	 * @param An
	 *            array of persons
	 * @return True if oldest, false otherwise
	 */
	public boolean olderThan(Persona[] others) {
		for (Persona p : others) {
			if (this.isOlder(p) > 0) {
				return false;
			} else if (this.isOlder(p) == 0) {
				if (!this.nameSurname.equals(p.getNameSurname())) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Returns the oldest person in an array
	 * 
	 * @param Array
	 *            of persons
	 * @return The oldest person if there is one, or null
	 */
	public static Persona oldest(Persona[] persone) {
		for (Persona p : persone) {
			if (p.olderThan(persone)) {
				return p;
			}
		}
		return null;
	}

}
