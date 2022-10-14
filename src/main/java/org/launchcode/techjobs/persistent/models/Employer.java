package org.launchcode.techjobs.persistent.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OnetoMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
public class
Employer extends AbstractEntity {

    @Size(min=3, message="This location needs to have at minimum three characters")
    @NotNull
    @NotBlank
    private String location;

    @OnetoMany()
    @JoinColumn(name = "employer-id")
    private final List<Job> jobs = new ArrayList<>();

    public Employer() {}

    public Employer(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employer)) return false;
        if (!super.equals(o)) return false;

        Employer employer = (Employer) o;

        return getLocation() != null ? getLocation().equals(employer.getLocation()) : employer.getLocation() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getLocation() != null ? getLocation().hashCode() : 0);
        return result;
    }


}
