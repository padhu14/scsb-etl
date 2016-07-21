package org.recap;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.recap.repository.XmlRecordRepository;
import org.recap.route.FTPRouteBuilder;
import org.recap.route.JMSReportRouteBuilder;
import org.recap.route.XmlRouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by angelind on 21/7/16.
 */
@Component
public class ReCAPCamelContext {

    Logger logger = LoggerFactory.getLogger(ReCAPCamelContext.class);

    CamelContext context;
    XmlRecordRepository xmlRecordRepository;

    private String xmlTagName;
    private String inputDirectoryPath;
    private Integer poolSize;
    private Integer maxPoolSize;
    private String reportsDirectory;
    private String ftpRemoteServer;
    private String ftpUserName;
    private String ftpKnownHost;
    private String ftpPrivateKey;

    private JMSReportRouteBuilder jmsReportRouteBuilder;
    private XmlRouteBuilder xmlRouteBuilder;
    private FTPRouteBuilder ftpRouteBuilder;


    @Autowired
    public ReCAPCamelContext(CamelContext context, XmlRecordRepository xmlRecordRepository,
                             @Value("${etl.split.xml.tag.name}") String xmlTagName,
                             @Value("${etl.load.directory}") String inputDirectoryPath,
                             @Value("${etl.pool.size}") Integer poolSize, @Value("${etl.max.pool.size}") Integer maxPoolSize,
                             @Value("${etl.report.directory}") String reportsDirectory, @Value("${ftp.userName}") String ftpUserName,
                             @Value("${ftp.remote.server}") String ftpRemoteServer, @Value("${ftp.knownHost}") String ftpKnownHost,
                             @Value("${ftp.privateKey}") String ftpPrivateKey) {
        this.context = context;
        this.xmlRecordRepository = xmlRecordRepository;
        this.xmlTagName = xmlTagName;
        this.inputDirectoryPath = inputDirectoryPath;
        this.poolSize = poolSize;
        this.maxPoolSize = maxPoolSize;
        this.reportsDirectory = reportsDirectory;
        this.ftpRemoteServer = ftpRemoteServer;
        this.ftpUserName = ftpUserName;
        this.ftpKnownHost = ftpKnownHost;
        this.ftpPrivateKey = ftpPrivateKey;
        init();
    }

    private void init() {
        try {
            addComponents();
            addDefaultRoutes();
        } catch (Exception e) {
            logger.error("Exception : " + e.getMessage());
        }
    }

    public void addRoutes(RouteBuilder routeBuilder) throws Exception {
        context.addRoutes(routeBuilder);
    }

    public void addDefaultRoutes() throws Exception {
        addRoutes(getXmlRouteBuilder());
        addRoutes(getJMSReportBuilder());
        addRoutes(getFtpRouteBuilder());
    }

    private JMSReportRouteBuilder getJMSReportBuilder() {
        if (null == jmsReportRouteBuilder) {
            jmsReportRouteBuilder = new JMSReportRouteBuilder();
        }
        return jmsReportRouteBuilder;
    }

    private void addComponents() {
        context.addComponent("activemq", ActiveMQComponent.activeMQComponent("vm://localhost?broker.persistent=false"));
    }

    public RouteBuilder getXmlRouteBuilder() {
        if (null == xmlRouteBuilder) {
            xmlRouteBuilder = new XmlRouteBuilder();
            xmlRouteBuilder.setXmlTagName(xmlTagName);
            xmlRouteBuilder.setInputDirectoryPath(inputDirectoryPath);
            xmlRouteBuilder.setPoolSize(poolSize);
            xmlRouteBuilder.setMaxPoolSize(maxPoolSize);
            xmlRouteBuilder.setXmlRecordRepository(xmlRecordRepository);
        }
        return xmlRouteBuilder;
    }

    public RouteBuilder getFtpRouteBuilder() {
        if(null == ftpRouteBuilder) {
            ftpRouteBuilder = new FTPRouteBuilder();
            ftpRouteBuilder.setFtpKnownHost(ftpKnownHost);
            ftpRouteBuilder.setFtpPrivateKey(ftpPrivateKey);
            ftpRouteBuilder.setFtpRemoteServer(ftpRemoteServer);
            ftpRouteBuilder.setFtpUserName(ftpUserName);
            ftpRouteBuilder.setReportsDirectory(reportsDirectory);
        }
        return ftpRouteBuilder;
    }
}