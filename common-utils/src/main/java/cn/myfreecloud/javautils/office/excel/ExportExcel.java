package cn.myfreecloud.javautils.office.excel;//package cn.myfreecloud.cn.myfreecloud.utils.office.excel;
//
//import lombok.extern.slf4j.Slf4j;
//
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.net.URLEncoder;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Slf4j
//public class ExportExcel {
//
//    public static final String TYPE_1 = "1";
//    /**
//     * 导出Excel工具类
//     * @param fileName
//     * @param cols
//     * @param colsDis
//     * @param mapList
//     * @param response
//     * @param request
//     * @param type
//     * @return
//     */
//    public boolean downloadExcel(String fileName, String cols, String colsDis, List<Map<String, Object>> mapList, HttpServletResponse response, HttpServletRequest request, String type) {
//
//        response.reset();
//
//        response.setContentType("text/x-plain");
//
//        try (ServletOutputStream out = response.getOutputStream()){
//
//            /**文件名乱码处理*/
//            String fileNameRes = "";
//            String userAgent = request.getHeader("user-agent").toLowerCase();
//            if (userAgent.contains("msie") || userAgent.contains("edge") || userAgent.contains("trident")) {
//                //IE
//                fileNameRes = URLEncoder.encode(fileName, "UTF-8");
//            } else {
//                //非IE
//                fileNameRes = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
//            }
//
//            response.setHeader("Content-disposition", "attachment; filename=" + fileNameRes);
//
//            String[] cell = cols.split(",");
//            String[] cellDis = colsDis.split(",");
//            List<Map<String, String>> cellsList = new ArrayList();
//            for(int i = 0; i < cell.length; ++i) {
//                Map<String, String> map = new HashMap();
//                map.put(cell[i], cellDis[i]);
//                cellsList.add(map);
//            }
//            List<Map> tempMapList = new ArrayList();
//            tempMapList.addAll(mapList);
//            byte[] bytes;
//            if (TYPE_1.equals(type)){
//                bytes = ExcelUtilFor2007.exportExcelDataForOneBy2007(cellsList, tempMapList);
//            }else {
//                bytes = ExcelUtilFor2007.exportExcelDataForOneForOutline(cellsList, tempMapList);
//            }
//            out.write(bytes);
//            out.flush();
//            return true;
//        } catch (Exception var14) {
//            log.error(var14.getMessage());
//            return false;
//        }
//    }
//}
//
