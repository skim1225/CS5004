/**
 *	Represents	an	Author	with	their	details--name,	email	and	physical	address
 *
 *	@author	therapon
 *
 */
public class Author {
    private Name name;
    private Email email;
    private Address address;

    /**
     * Creates	a	new	author	given	the	author's	name,	email	and	address	as	strings.
     *
     * @param    name    the	author's	name
     * @param    email    the	author's	email	address
     * @param    address    the	authors	physical	address
     */
    public Author(Name name, Email email, Address address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name=" + name +
                ", email=" + email +
                ", address=" + address +
                '}';
    }
}