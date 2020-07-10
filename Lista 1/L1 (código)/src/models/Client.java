package models;

import java.util.Calendar;

public class Client implements Comparable<Client> {
    ClientList clientList = new ClientList();
    private String name;
    private String phone;
    private String gen;
    private String birth;
    private int years;
    private boolean[] services = new boolean[13];

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGen(String gen) {
        if(gen.equalsIgnoreCase("m")) {
            this.gen = "Masculino";
        } else if(gen.equalsIgnoreCase("f")) {
            this.gen = "Feminino";
        }
    }

    public void setBirth(String birth) {
        this.birth = birth;
        setYears(birth);
    }

    public void setYears(String birth) {
        int day = Integer.parseInt(birth.substring(0, 2));
        int month = Integer.parseInt(birth.substring(2, 4));
        int year = Integer.parseInt(birth.substring(4));

        Calendar calendar = Calendar.getInstance();
        int dayc = calendar.get(Calendar.DAY_OF_MONTH);
        int monthc = calendar.get(Calendar.MONTH) + 1;
        int yearc = calendar.get(Calendar.YEAR);

        int yOld = yearc - year - 1;
        if(day <= dayc && month == monthc || month < monthc) {
            this.years = yOld + 1;
        } else {
            this.years = yOld;
        }
    }

    public void setServices(int service) {
        if(this.services[service] == true) {
            this.services[service] = false;
        } else {
            this.services[service] = true;
        }
    }

    public String getGen() {
        return gen;
    }

    public int getYears() {
        return years;
    }

    public boolean getServices(int index) {
        return services[index];
    }


    public String toString() {
		String profile =  "Nome: " + this.name + "\n" +
							"Telefone: " + this.phone + "\n" + 
                            "Gênero: " + this.gen + "\n" +
                            "Data de nascimento: " + this.birth + "\n" +
                            "Idade: " + years + "\n" +
                            "Serviços:\n";
        for(int i = 0; i < clientList.services.length; i++) {
            if(this.services[i] == true) {
                profile += clientList.services[i] + "\n";
            }
        }
		return profile;
    }

    public int compareTo(Client o) {
        return this.name.compareTo(o.name);
    }
}