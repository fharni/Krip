package de.falkharnisch.web.jupa.services;

import de.falkharnisch.web.jupa.database.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Transactional
@ApplicationScoped
public class AuditService extends BaseService<Audit> {

    public void saveAuditMember(AuditMember member) {
        mergeOther(member);
    }

    private Map<Integer, AuditStatus> statusMap;

    @PostConstruct
    private void initAnnotations() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<AuditStatus> query = builder.createQuery(AuditStatus.class);
        query.from(AuditStatus.class);
        List<AuditStatus> status = em.createQuery(query).getResultList();
        statusMap = status.stream().collect(Collectors.toMap(AuditStatus::getId, a -> a));
    }

    public AuditStatus getStatus(STATUS status) {
        return statusMap.get(status.id);
    }

    public List<Audit> getAuditsForClub(Club club) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Audit> query = builder.createQuery(Audit.class);
        Root<Audit> root = query.from(Audit.class);
        query.where(builder.equal(root.get(Audit_.club), club));
        return em.createQuery(query).getResultList();
    }

    public Integer getLastAuditId(Club club) {
    	CriteriaBuilder builder = em.getCriteriaBuilder();
    	CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
    	Root<Audit> root = query.from(Audit.class);
    	query.select(builder.max(root.get(Audit_.displayId)));
    	query.where(
    			builder.equal(root.get(Audit_.club), club)
    			);
    	return em.createQuery(query).getSingleResult();
    }

    public List<Audit> getAuditsForFederation(Federation federation) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Audit> query = builder.createQuery(Audit.class);
        Root<Audit> audit = query.from(Audit.class);
        Join<Audit, Club> clubJoin = audit.join(Audit_.club);
        Join<Club, District> districtJoin = clubJoin.join((Club_.district));
        query.where(builder.equal(districtJoin.get(District_.federation), federation));
        return em.createQuery(query).getResultList();
    }

    public List<AuditMember> getMembersForAudit(Audit audit) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<AuditMember> query = builder.createQuery(AuditMember.class);
        Root<AuditMember> root = query.from(AuditMember.class);
        query.where(builder.equal(root.get(AuditMember_.audit), audit));
        return em.createQuery(query).getResultList();
    }

    public List<Audit> getAuditsForAuditor(User user) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Audit> query = builder.createQuery(Audit.class);
        Root<Audit> root = query.from(Audit.class);
        query.where(builder.equal(root.get(Audit_.auditor), user));
        return em.createQuery(query).getResultList();
    }

    public void approveAudit(Audit audit) {
        AuditStatus auditStatus = statusMap.get(STATUS.DEFINE_PARTICIPANTS.id);
        audit.setStatus(auditStatus);
        merge(audit);
    }

    public void removeAuditMember(AuditMember member) {
        remove(member);
    }

    public void persistAuditMember(AuditMember member) {
        persistOther(member);
    }

    public enum STATUS {
        REQUEST(1),
        DEFINE_PARTICIPANTS(2),
        RELEASE(3),
        FINISH(4);

        int id;

        STATUS(int id) {
            this.id = id;
        }
    }
}
