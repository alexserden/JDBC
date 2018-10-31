package model;

public class Developers extends IdEntity {
  private String name;
  private Skills skill;
  private Projects project;
  private Companies companies;

    public Developers(Long id, String name, Skills skill, Projects project, Companies companies) {
        super(id);
        this.name = name;
        this.skill = skill;
        this.project = project;
        this.companies = companies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Skills getSkill() {
        return skill;
    }

    public void setSkill(Skills skill) {
        this.skill = skill;
    }

    public Projects getProject() {
        return project;
    }

    public void setProject(Projects project) {
        this.project = project;
    }

    public Companies getCompanies() {
        return companies;
    }

    public void setCompanies(Companies companies) {
        this.companies = companies;
    }

    @Override
    public String toString() {
        return "Developers{" +
                "name='" + name + '\'' +
                ", skill=" + skill +
                ", project=" + project +
                ", companies=" + companies +
                '}';
    }
}
