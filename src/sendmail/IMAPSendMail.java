package sendmail;

//$Id$

import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.Vector;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import org.json.JSONObject;

import com.adventnet.crm.common.util.ContentTypeConstants;
import com.adventnet.crm.integration.emails.util.MailUtil;
import com.adventnet.crm.integration.imap.util.CrmIMAPConstants;
import com.adventnet.crm.security.util.SendMailAuthenticator;
import com.sun.mail.smtp.SMTPMessage;
import com.sun.mail.smtp.SMTPTransport;

public class IMAPSendMail {

	public static void main(String [] arg) throws Exception
	{
		for( int i = 0; i < 25; i++ )
		{
			send();
			//Thread.sleep(100);
		}	
	}
	
	public static JSONObject send() throws Exception
	{

		String[] userNameArr = new String[]{"000.jai", "aa", "abdul.hameedh", "Ada 程宏伟", "adithyan.r", "admin", "Admin Support", "aghil.tu", "aghilkrishna", "Ajay", "Ajay Shankar", "Akilan Samuthira Pandy", "akshaya.muralidharan", "alamelu.r", "Amponvizhi Muthuswamy", "amy", "anandan.g", "ananthagovindarajan.at", "Anil Kumar", "AnithaRoslin AnithaRoslin", "anoop", "anoop mohan", "anoop.mohan", "antispam-team", "anusanth.jeba", "applecare", "arivuchelvan.p", "arulanandam.j", "arulanandam.j(Arul)", "Arumugam K", "Arun Kumar Pazhani", "Arun S", "Arun Sasikumar", "Arunkumar T", "arunkumar.bk", "arunkumar.mg", "arunkumar.ms", "arvind.ravi", "arvindr1234@gmail.com", "Ashok Kumar", "Ashok Kumar Krishnan", "ashwin.satriani@gmail.com", "August 6 2013 - CRM", "Azeez Khan M", "Bala", "Bala", "Bala Ram", "Balaganesh Sakthi Mohan", "Balaji Sivanath", "balasubramaniam.s", "Barani", "Barani.rajan", "bb", "bcc@zohocrm.com", "Beera Bala Veera Ganesh", "benny.soundaradas@one.verizon.com", "Bhagya Sedhu", "Bharadwaja Chavali(Bharath)", "bharathikannan.r", "bharathithasan.s", "boopathy.p", "boysinrythm@gmail.com", "Carlos Dieguez", "catchall", "catchall", "catchall", "CEO Navasankar", "Chairma Selvi", "chakaravarthi", "chandrapandian.ar", "Chandrasekar P", "Chandru J", "checktheNotProvided", "checktheNotProvided22", "Chiharu Hirota", "Chinmaya Biramanantham", "chitra", "Chitrapandian Nachiappan", "Chitrapandian Nachiappan(Pandyah !!)", "contactkannan1986@gmail.com", "crm-escalation", "crm-issues@zohocorp.com", "crm-mailteam@zohocorp.com", "crm-pmteam@zohocorp.com", "crm-qateam@zohocorp.com(crm-qateam@zohocorp.com)", "crm-securityteam@zohocorp.com", "crm-serverteam@zohocorp.com", "crm_34971000002944005@tasks.zohoprojects.com", "crm_mailclient@tasks.zohoprojects.com", "crmbcc2", "csena", "damu2142.ece@gmail.com", "david", "davidraj.k", "Dayanithi D", "deepak kumar", "deepak.r@cognizant.com", "devanathan.j", "Dhanasekar Kadirvel", "Dhayanathi Vijayakumar", "dileep.t", "Dilip", "Dilip(dilip)", "dina.arr@gmail.com", "Dinagaran Marimuthu", "dinesh C", "dinesh.kumar54@wipro.com", "dinesh_topstar1@yahoo.co.in", "dineshtts", "Divya Dharshana N", "DJ", "dudeprakee@gmail.com", "dummyprakee@gmai.com", "durairaj.s", "E l a v a r a s a n", "ecstaticprakash@gmail.com", "Edwin Pattudurai", "Elango Sakthivel(elangos)", "elangovan s", "Fawkes Guy", "gadgets", "ganesh.m", "ganesh.sv", "Ganeshprabhu Rajendran", "Gautham Pasupuleti", "Gautham R", "gokulraj", "Gopal", "gopals", "gopikrishnan.g", "gopinathan.v", "govindaraj.r(Govind)", "Govindarajan", "Gurumoorthy K", "Gurumurthy Kalyanaraman", "Guruprasad sundaresan", "hamilton", "hariharasudhan.sk", "hariperumal.e", "haripriya.maheswaraiah(haripriya)", "haripriya.r R", "heather", "Heerachand Athmarao", "himanesh", "iam-team", "iam@zohocorp.com", "iloveindia", "im-team@zohocorp.com", "integration-team@zohocorp.com", "J.Sujith Regan", "jacline.s", "Jagadeesh Goddumuri", "Jagan Ranganathan", "Jagan Ranganathan(ZohoMail)", "jaganathan.p", "Jai Ganesh", "jaiho", "Janakiram R", "jarko", "Jayakumar I", "Jayakumar Ilangovan", "Jayanthi T", "Jayavignesh K S D", "Jennifer Solomon", "Jeri John Prabhu Deva George", "Jevitha Sathya Narayanan", "Jevitha Sathya Narayanan(jevitha)", "jeyaprakash.mrn", "jjycxo", "jjycxo", "john", "John Maurice", "joseph.rathinavel", "jsangeetha", "Jude Martin Antony Doss", "Kalavathi Narayanan", "Kaleeswaran  Naryanan", "Kamalakannan K", "Kanagamanikandan", "Kannan Sampath", "Karthick K", "karthick.v", "karthiga.c", "karthik sankaran", "Karthika Muthiah", "Karthikayini P", "Karthikeyan Krishnan(karthi)", "Karthipanraj K", "karuppasamy.e", "Karuppuchamy Karuppuchamy", "kasirajan.k", "keerthi.r", "Kishor Kamath D", "ks915@chrysler.com", "Kumaran R", "Kumaresan Shanmugam", "kumari.g", "Lakshmanan.M", "lead_1kt6wd", "leads_12232", "Logs Team", "Lokesh Srinivasalu", "longtextMailBoxIssue", "Lourdu Sahaya Raja Charles Antoney", "Maddy", "madhan.n", "Madhukar Bharti", "Magda Karpińska", "mahalakshmi.v", "Mahesh Kumar Karunakaran", "maheshkumar", "maintenance@zohocorp.com", "Mani Vembu", "Manikandan Subramanian", "Manimaran Vasudevan", "Manimekalai Kunjithapatham", "Mano Krishnan", "Manoj T", "manuel.ap", "mareeswaran.c", "Maria Alphonse Raja", "Marikumar K", "Mathankumar", "mathiganesh.t", "mohamed.mohideen", "mohammed.mathin", "mohammed.shameerfaizal", "Mohan Kumar Soundararajan", "Mohan Sai Krishna", "mohan18red@gmail.com", "mohanelumalai@hcl.com", "Mudit (synergy telecom Pvt Ltd)", "mukilarasan.r", "muniasankar d", "Murali Ponnusamy", "Muthu Ganesh Jothi", "Muthu Sankar Hari Hara Subra Manian", "muthuganeshj", "muthukumar.p", "muthuraja", "Muthuvijayan Thakshayani", "nagarajan.anbazhagan", "nalini.rajalingam", "Narayanan R", "naresh.b", "nareshram.l", "nausadh.ar", "navarajan.a", "Naveen Venkatesan", "nelrosz@gmail.com", "nepoleon.ms", "newsletters", "Nicholas Boyes-Hunter", "nick.cookson", "Nirmal Raja Gurusamy", "Nithya K", "NS Perumal", "outlooktest", "paragprasad", "Parthasarathy Krishnamoorthy", "Parthiban Periyasamy", "Paschalraj Mathias", "Paul Ponraj", "payroll", "pazhani.gk", "perumal.m", "Petchimuthu Nallakannu", "Peter Balaji l Zoho Corp", "Peter Balaji(Peter)", "phalgun.lodaya", "pm", "Pon Pavitra Jothi", "Ponns", "Prabu", "Prabu gj(gjprabu)", "prabu.k", "pragatheswaran.v", "Prakash Shunmuga Sundaram(S.Prakash)", "prakash.murugesan", "prakash.murugesan+232", "Prakee dudey", "Pramod Nanduri", "praneeshkumar.k", "Prasanna", "Pratheesh A", "Praveen R", "Pravinkumar Raghuram", "pravinr1988@gmail.com", "Prembharadwaj CEO.vr VR", "premierrealtyfl", "premrob19@gmail.com", "Priya Dharshini", "Priyadharshini Elumalai", "priyanga.v", "Pugalanthi.m", "Raafi Mohammed", "Raam Prashanth N S", "Radha Krishnan(Radha K)", "Radha Vembu", "Radhika Vasant Rao", "Raghu Ram T", "raj.ganesh01", "Raja Sellappan", "rajaganapathy.j", "Rajakula Sekara Pandian Karuppiah", "rajarathinam.k", "Rajasankar Viswanathan", "Rajesh D5", "Rajesh Devaraj", "Rajesh Kumar M M", "rajesh v", "rajesh.devaraj87@gmail.com", "rajesh.sra", "RajeshKannanMuthusamy(Mickie)", "Rajganesh Subramanian", "rajganesh01@gmail.com", "raji_valli88", "rajkamal.sv", "rajkanth.rm", "Rakeeb Mohamed Mubeen", "rakesh", "Ram Chiranjeevi Ramachandran", "Rama Krishnan Narayanan", "ramakanth.r", "ramakrishnan.sv3", "ramakrishnan.sv7@wipro.com", "ramaprasath.rs", "Ramesh Balasekaran", "Ramesh Mathialagan(ramesh)", "Ramkumar Ganesan", "Ramkumar S", "Ramya A", "Ranjith Kumar Diraviyam", "Ravikumar Govindarajan", "Ravindran Gopalakrishnan", "Renuka Devi R", "revathi.pk", "Revathy Durai Rajan", "Rishi Krishnan", "Ritesh Kumar Rathi", "riyaz.a", "rreina", "Ruben Kannan", "ruhdis@gmail.com", "Rustam - Banya Concept", "S S G Gopal(Gopal)", "sai kamalesh.y", "Sai Kumar Cheekatimalla", "Sairam", "saivenkatasubramaniam.r", "Saminathan Arumugam(Saminathan)", "sampath.js", "samson.coke", "Sangeetha Balaji", "sangeetha.balaji", "Sanjith J K", "Santha kumar", "Santhosh Kumar S(Santhosh IAM team)", "Santhosh-3.S-3", "santhosh.sarma", "santhosh.srinivasan", "santhoshkumar.r", "santhoshkumar.rs kumar", "santosh sellathurai", "santosterock@gmail.com", "saravanakumar.j", "Saravanan Ganapathy", "Saravanan Govindaraj(saravanang)", "Saravanan Raj(rsaravanan)", "Saravanan Venkatasubramani", "Saravanan Venkatasubramani(Saravanan)", "saravanaprakash.t", "sarojraman.r", "sas-support@zohocorp.com", "sathak.abdullah", "satheeshkumar.j", "Sathesh Kumar D", "Sathiesh kumar", "Sathik Basha", "sathish", "sathish", "sathish", "Sathish kumar", "Sathish Kumar", "sathish kumar", "sathish kumar S", "sathish.kumar.s", "sathish00", "sathishkumar.rs(mums)", "sathishkumar.sekar", "sathishkumar.sekar+0711", "sathishkumar.sekar+10@zohocorp.com", "sathishkumar.sekar+11@zohocorp.com", "sathishkumar.sekar+12@zohocorp.com", "sathishkumar.sekar+13@zohocorp.com", "sathishkumar.sekar+14@zohocorp.com", "sathishkumar.sekar+15@zohocorp.com", "sathishkumar.sekar+16@zohocorp.com", "sathishkumar.sekar+17@zohocorp.com", "sathishkumar.sekar+2@zohocorp.com", "sathishkumar.sekar+3@zohocorp.com", "sathishkumar.sekar+4@zohocorp.com", "sathishkumar.sekar+5@zohocorp.com", "sathishkumar.sekar+6@zohocorp.com", "sathishkumar.sekar+7@zohocorp.com", "sathishkumar.sekar+8@zohocorp.com", "sathishkumar.sekar+9@zohocorp.com", "sathishkumar.sekar+ponns", "sathishm", "sathishm+cc", "sathishm+to", "sathishs39", "Sathya Prabha Arvind", "sd", "security-audit", "security-support@zohocorp.com", "sekar", "Sellathurai Santosh", "Selvam Ramasamy", "senthamil  bharathi", "Senthil Ganesh", "senthilkumar.g", "senthilkumar.n", "Shahul Hameed Nowshath", "Shahul Shamsudeen Abubacker(Shahul Shamsudeen)", "Shailesh Kumar Davey", "Shankar Ravindranath", "Shanmuga Perumal N(NSP)", "Shanmuga Raja", "Shanmugaapriyan P", "shanmugakumar.b", "shanmuganathan.r(Shan)", "Sharanya", "Shree", "Shri Vishnu D", "Siva Sankar P S", "Sivakumar Krishnamoorthy", "Sivaprasanth S", "Sivashangari M", "skr_sriram1@yahoo.com", "Sneha S", "sohail", "Solomon Raja Sekaran", "sri.chandrasekaran@sbi.co.in", "Sridhar K Sundaram", "Sridhar Maddireddy", "Sridhar Vembu", "Srimathy", "Srinivasan Govindan", "srinivash.arumugam", "sriraghavan.ges", "Sriram Raghunathan", "Sriram Raghunathan", "sriram.rajamanickam", "srirampandian.s tyuu firstname wer", "Srivignesh S(Srivignesh)", "ssk.csez@gmail.com", "ssk.geek", "ssk.localzoho", "ssk.localzoho+1", "ssk.localzoho+2102", "ssk.localzoho+32487", "ssk.zoho", "ssk.zoho", "sskadmin@zohocorp.com", "ssksales", "ssksekar", "ssksekar", "ssksekar", "ssksekar", "ssksekar", "ssksekar", "ssksekar", "ssksekar+10", "ssksekardlf", "subathra.selvaraj", "subramani.thiruppal(Blacky)", "Sudharsan K P", "Sudharshan S", "Sujesh.S", "sundarracer1@gmail.com", "sundarracer3@gmail.com", "sundharesan.p", "sunilkumar.k", "support", "support-zohoaccounts", "support@zohomail.com", "support@zohomail.com", "Surenkumar v", "Suresh | ManageEngine", "sureshkumar.r", "suriyaprakash.s", "swaminathan.k", "Syed(syed yusuf)", "sysadmin", "sysadmin-team", "tamilarasan.s", "test", "Thangaraj Ramasamy", "Thirumavalavan R", "Thiruppathi Palanichamy(Thipu)", "Tom", "translations", "Udhaya Charen", "udhaya.girish", "Uma Saradha", "unzyqr", "Vaagdevi Ravishankar", "vaidyanathan.k", "vaishnav.ramesh", "Varun Raj S", "vasanthan.m(vasanth)", "velavan.ambika", "venkatesan.mayakrishnan(Venkatesh)", "Venkatesh Devalla", "Vetri", "Vidya Priya", "Vignesh S", "vignesh.sr", "Vijay Krishna", "vijay sekar", "vijay.k", "Vijayakumar Sadagopan", "Vijayakumar Ulaganathan", "Vijayan Thirugnanam", "vijayraj.jain", "Viji Raghavan Gopalakrishnan", "Vikash Kumaran V", "vinay.joshi", "Vincent", "Vinod Kumar Venkatesa Perumal", "Vinod Raj", "vinodhkumar.br", "Vinoth Kumar vinothkumar.k", "Vishal M", "vishnuvardhan.a", "Viswanath M", "Viswaprasath K S", "vivek.prabakaran", "vivek@imst.de", "Walaa", "Yogendra Babu Venkatapathy", "Yogesh", "Yu Zhao", "Yukesh Kumar Srinivasan(Yuki)", "yuvaraj.n", "zm-api", "zmail-users", "zoho-discussions@zohocorp.com", "zoho-techsupport", "zohocrm-qa", "zohocrm-support@zohocorp.com", "zohocrm@zohocorp.com", "zohodiscussions@zohocorp.com", "zorro-team", "zorro@zohocorp.com", "zteam", "zteam", "zteam", "ZW EVENTOS"};
		String userFullName = userNameArr[ new Random().nextInt(500) ];
		String defFromAddress = "ssk.csez@zohocorp.com";
		

		Session smtpSession = getSMTPSession();

		SMTPMessage msg = new SMTPMessage(smtpSession);

		InternetAddress fromAddress = new InternetAddress( defFromAddress, userFullName, ContentTypeConstants.UTF8 );
		msg.setFrom( fromAddress );

		msg.setRecipients(RecipientType.TO, convertStringToAddress("ssk.zoho@gmail.com") );

		msg.setSubject( userNameArr[ new Random().nextInt(500) ] + " Subject " + userFullName, ContentTypeConstants.UTF8);

		/*
		if(mailDetails.getCcAddr() != null && !"".equals(mailDetails.getCcAddr())){
			msg.setRecipients( RecipientType.CC, convertStringToAddress( mailDetails.getCcAddr() ));
		}

		if(mailDetails.getBccAddr() != null && !"".equals(mailDetails.getBccAddr())){
			msg.setRecipients( RecipientType.BCC, convertStringToAddress( mailDetails.getBccAddr() ));
		}

		if(mailDetails.getReplyToAddr() != null && !"".equals(mailDetails.getReplyToAddr())){
			msg.setReplyTo(convertStringToAddress(mailDetails.getReplyToAddr()));
		}

		String messageID = mailDetails.getMID();
		String threadRef = mailDetails.getReferences();

		if(messageID != null){
			msg.setHeader("In-Reply-To", messageID);//No I18N
		}
		
		if(threadRef != null){
			msg.setHeader("References", threadRef );//No I18N
		}else {
			msg.setHeader("References", messageID );//No I18N
		}
		 */
		
		msg.setSentDate(new Date());
		msg.addHeader("MIME-Version", "1.0");//No I18N

		String content = "This is my content";

		//create and fill the first message part
		Vector<MimeBodyPart> vBodyParts = new Vector<MimeBodyPart>();
		MimeBodyPart bodyPart = new MimeBodyPart();

		if( content != null )
		{
			StringBuffer sbuf = new StringBuffer();
			content = sbuf.toString();
			sbuf = new StringBuffer();

			content = sbuf.toString();
			MimeMultipart multiPart = new MimeMultipart("alternative");//No I18N
			MimeBodyPart bodyPart1 = new MimeBodyPart();
			bodyPart1.setContent(MailUtil.extractText(content), "text/plain; charset=\"UTF-8\"");//No I18N
			multiPart.addBodyPart(bodyPart1);

			String head="<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">";//No I18N
			bodyPart.setContent(head + content, "text/html; charset=\"UTF-8\""); //No I18N
			multiPart.addBodyPart(bodyPart);
			MimeBodyPart wrap =  new MimeBodyPart();// creating a child body part ( a part of the multipart)
			wrap.setContent(multiPart); // setting the content of this bodypart to be a multipart (i.e child multipart). Mac mail related fix -- Nesting gets applied here (One multipart inside a body part of another multipart)
			vBodyParts.add(wrap);
		}
		
		Multipart mp_main = new MimeMultipart("related");// Create a parent multipart in mixed type, Inside this attachment will be a part and another part will be the content with inline images if any. Mac fix //NO I18N

		//Add any file attachemnts
		
		//create the Multipart mime. This is the child multi part and this multipart itself will be a part of the main multi part. Since it contains only inline images and content it can be a related type multipart -- Mac mail prblem fix
		Multipart mp = new MimeMultipart("mixed");//No I18N
		//adding all  content and images into the child multipart // Mac mail problem fixed
		for (int i = 0; i < vBodyParts.size(); i++)
		{
			mp.addBodyPart((MimeBodyPart)vBodyParts.elementAt(i));
			mp_main.addBodyPart((MimeBodyPart)vBodyParts.elementAt(i));
		}
		
		if(mp.getCount()>0){ // this must always be greater than zero else error will happen hence check added.
			MimeBodyPart mbp_child_content =  new MimeBodyPart();// creating a child body part ( a part of the multipart)
			mbp_child_content.setContent(mp); // setting the content of this bodypart to be a multipart (i.e child multipart). Mac mail related fix -- Nesting gets applied here (One multipart inside a body part of another multipart)
			mp_main.addBodyPart(mbp_child_content);// else if there are no attachments just add the body part (contains a multipart) and it automatically takes care of the positioning..  defaults to one.  This is done to avoid arrayindexout of bound exception
		}

		//msg.setContent(mp_main);
		
		msg.setContent(mp);
		
		SMTPTransport smtpTransport = null; 
		JSONObject statusJSON = new JSONObject();
		try
		{
			Long startTime = System.currentTimeMillis();
			smtpTransport = (SMTPTransport)smtpSession.getTransport("smtp");//No I18N
			smtpTransport.connect();
			Long connectEndTime = System.currentTimeMillis();
			smtpTransport.sendMessage(msg, msg.getAllRecipients());
			Long sendEndTime = System.currentTimeMillis();
			statusJSON.put("status", true);
//			CrmStats.getInstance(CrmStatsFeatures.IMAP_OUTGOING).hit(OrgUtil.getCurrentZGID().toString());
		}
		catch ( Exception e ) 
		{
			statusJSON.put("status", false);
			if(e.getMessage() != null){
				statusJSON.put("error", e.getMessage());
			}else{
				statusJSON.put("error", "Unable to send");
			}
		}
		finally
		{
			safeCloseTransport(smtpTransport);
		}
		return statusJSON;
	}

	private static void safeCloseTransport( SMTPTransport smtpTransport )
	{
		if ( smtpTransport != null )
		{
			try
			{
				smtpTransport.close();
			}
			catch( MessagingException msgEx )
			{
				System.out.println( msgEx );
			}
		}
	}
	
	
	public static Session getSMTPSession() throws Exception
	{

		//{"smtp":{"SCT":1,"PORT":465,"ALIASES":["ssk.zoho@gmail.com"],"AUTH":1,"EMAIL":"ssk.zoho@gmail.com","SVR":"","PASS":"f5654d57a4c00007bd78132db7a0017cf2125b349852c172c9550d38852b9e1b","USER":"ssk.zoho"}
		
		Properties props = new Properties();

		props.setProperty( "mail.smtp.host", "smtp.gmail.com" );
		props.setProperty( "mail.smtp.from", "ssk.localzoho@gmail.com" );
		props.setProperty( "mail.smtp.port", "465" );
		props.setProperty( "mail.smtp.connectiontimeout", CrmIMAPConstants.SMTP_CONNECTION_TIMEOUT );
		props.setProperty( "mail.smtp.timeout", CrmIMAPConstants.SMTP_READ_TIMEOUT );
		props.setProperty( "mail.smtp.ssl.enable", "true");
		props.setProperty( "mail.debug", "true");
		
		boolean isAuthRequired = true;
		Session session = null;
		if(isAuthRequired)
		{
			props.setProperty( "mail.smtp.auth", "true");
			String userName = "ssk.localzoho@gmail.com";
			String password = "vembu123";
			
			Authenticator authen = new SendMailAuthenticator(userName, password);
				session = Session.getInstance(props, authen);
		}else{
			props.setProperty( "mail.smtp.auth", "false");
			session = Session.getInstance(props);
		}

		return session;

	}
	
	private static InternetAddress[] convertStringToAddress(String addreses) throws Exception
	{
		String[] addressArr = addreses.split(",");
		InternetAddress[] toAddr = new InternetAddress[addressArr.length];
		for( int i = 0 ; i < addressArr.length ; i++ ){
			toAddr[i] = new InternetAddress( addressArr[i] );
		}
		return toAddr;
	}
}

