package mvc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("FeeDao")
public class FeeDao {
	@Autowired
	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	@Transactional
	public void update(String rollnumber, String fees, String paid) {
		Fee fee = new Fee();
		fee.setFees(fees);
		fee.setPaid(paid);
		fee.setRollnumber(rollnumber);
		
		this.template.update(fee);;
	}
	
	public Fee getbyroll(String rollnumber) {
		Fee fee = new Fee();
		fee = this.template.get(Fee.class, rollnumber);
		return fee;
	}
	
	public List<Fee> getall(){
		List<Fee> list = this.template.loadAll(Fee.class);
		return list;
	}
	
    public List<Fee> getbypaid(String paid) {
        return this.template.execute(new HibernateCallback<List<Fee>>() {
            @Override
            public List<Fee> doInHibernate(Session session) {
                String hql = "FROM Fee fee WHERE fee.paid = :status";
                Query<Fee> query = session.createQuery(hql, Fee.class);
                query.setParameter("status", paid);
                return query.list();
            }
        });
    }
    @Transactional
    public void add(String rollnumber,String fees, String paid) {
    	Fee fee = new Fee();
    	fee.setFees(fees);
    	fee.setPaid(paid);
    	fee.setRollnumber(rollnumber);
    	
    	this.template.save(fee);
    }
    @Transactional
    public void delete(String rollnumber) {
    	Fee fee = getbyroll(rollnumber);
    	this.template.delete(fee);
    }

}
