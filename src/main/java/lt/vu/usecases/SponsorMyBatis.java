package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.mybatis.dao.SponsorMapper;
import lt.vu.mybatis.model.Sponsor;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

@Model

public class SponsorMyBatis {
    @Inject
    private SponsorMapper sponsorMapper;

    @Getter
    private List<Sponsor> allSponsors;

    @Getter @Setter
    private Sponsor sponsorToCreate = new Sponsor();

    @PostConstruct
    public void init() {
        loadAllSponsors();
    }

    private void loadAllSponsors() {
        this.allSponsors = sponsorMapper.selectAll();
    }

    @Transactional
    @LoggedInvocation
    public String createSponsor() {
        sponsorMapper.insert(sponsorToCreate);
        return "/myBatis/sponsors?faces-redirect=true"; // Adjust navigation if needed
    }
}
