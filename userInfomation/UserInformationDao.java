package com.arg.gsbea.core.home;
import com.arg.gsbea.common.core.ProcMessage;
import com.arg.gsbea.common.core.TransactionalProcessor;
import com.arg.gsbea.common.model.usersinformationgraph.DonutGraph;
import com.arg.gsbea.common.model.usersinformationgraph.HightGraph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.json.JSONObject;

public class UserInformationDao {
    
    private static final Logger LOG = LogManager.getLogger(UserInformationDao.class.getName());
    private static UserInformationDao INSTANCE;
    
    public static UserInformationDao getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserInformationDao();
        }
        return INSTANCE;
    }
    
    public ProcMessage getDataUsersInfomation(String data) {
        
        ProcMessage pMsg = new ProcMessage();
        
        JSONObject json = new JSONObject(data);
        int year = json.getInt("year") - 543;
        int month = json.getInt("month");
        
        LOG.info("year"); LOG.info(year);
        LOG.info("month"); LOG.info(month);
        
        try {
            (new TransactionalProcessor() {
                @Override
                public void process(Session session, Transaction tx) {
                    LOG.info("<===[ getDataUserInfomationDao ]===>");
                    final int  hightGraph = 1;
                    final int  donutGraph = 2;
                    
                    List<Object> hightGraphResult = getDataGraphFromStoredProcedures(session,year,month,hightGraph);
                    List<Object> donutGraphResult = getDataGraphFromStoredProcedures(session,year,month,donutGraph);
                    
                    if (!hightGraphResult.isEmpty() && !donutGraphResult.isEmpty()) {
                        
                         List<HightGraph> hightGraphs = parseObjToModelHightGraph(hightGraphResult);
                         DonutGraph donutGraphs = parseObjToModelDonutGraph(donutGraphResult);
                         
                         Map<String,Object> obj=new HashMap();
                         obj.put("hightGraphs", hightGraphs);
                         obj.put("donutGraphs", donutGraphs);

                         pMsg.setEntries(obj);
                        
                    } else {
                        pMsg.setMessage("result is Empty");
                    } 
                }
            }).process();
        } catch (Exception e) {
            LOG.info(e.getMessage());
            pMsg.setMessage(e.getMessage());
        }
        return pMsg;
    }
    
    public List<Object> getDataGraphFromStoredProcedures(Session session,int year,int month,int tyeGraph) {
        StringBuilder hql = new StringBuilder();
        hql.append("exec PROC_USER_ACTIVE_GRAPH null,null," + year + "," + month + "," + tyeGraph);
        NativeQuery sqlDGraph = session.createNativeQuery(hql.toString());
        List<Object> graphResult = sqlDGraph.getResultList();
        return graphResult;
    }
    
    public DonutGraph parseObjToModelDonutGraph(List<Object> result){
        DonutGraph donut=new DonutGraph();
        for (Object object : result) {
            Object[] col = (Object[]) object;
            if (col[0] != null && !col[0].equals("")) {
                donut.setUserRegisterMonth(Integer.parseInt(col[0].toString()));
            }
            if (col[1] != null && !col[1].equals("")) {
                donut.setUserActiveMonth(Integer.parseInt(col[1].toString()));
            }
            if (col[2] != null && !col[2].equals("")) {
                donut.setUserInActiveMonth(Integer.parseInt(col[2].toString()));
            }
        }
        return donut;
    }
    
    public List<HightGraph> parseObjToModelHightGraph(List<Object> result) {
        List<HightGraph> listgraph = new ArrayList<>();
        for (Object object : result) {
            HightGraph graph = new HightGraph();
            Object[] col = (Object[]) object;
            if (col[0] != null && !col[0].equals("")) {
                graph.setuYear(Integer.parseInt(col[0].toString()));
            }
            if (col[1] != null && !col[1].equals("")) {
                graph.setuMonth(Integer.parseInt(col[1].toString()));
            }
            if (col[2] != null && !col[2].equals("")) {
                graph.setuDate(col[2].toString());
            }
            if (col[3] != null && !col[3].equals("")) {
                graph.setuRegister(Integer.parseInt(col[3].toString()));
            }
            if (col[4] != null && !col[4].equals("")) {
                graph.setuActive(Integer.parseInt(col[4].toString()));
            }
            listgraph.add(graph);
        }
        return listgraph;
    }
    
}

