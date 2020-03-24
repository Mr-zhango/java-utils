//package cn.myfreecloud.javautils.office.excel;
//
//import cn.myfreecloud.javautils.date.DateUtils;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.Font;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.*;
//
//import java.io.ByteArrayOutputStream;
//import java.math.BigDecimal;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//public class ExcelUtilFor2007 {
//    public static final String HEAD_DATA = "headData";
//    public static final String BODY_DATA = "bodyData";
//    public static final String ERROR_DATA = "errorData";
//    private static final String LOG_MESSAGE = ">>>>>>> exporting data to byte[]";
//    private static final String SHEET = "sheet1";
//    private static final String LOG_MESSAGE_RETURN = "return excel file with byte[]";
//    static Log logger = LogFactory.getLog(ExcelUtilFor2007.class);
//
//    private ExcelUtilFor2007() {
//    }
//
//
//    private static CellStyle getCellStyle(boolean isBoreder, short color, short fcolor, XSSFWorkbook wb) {
//        XSSFCellStyle style = wb.createCellStyle();
//        XSSFFont font = wb.createFont();
//        font.setFontHeightInPoints((short)10);
//        //font.setBoldweight((short)700);
//        font.setFontName("Courier New");
//        font.setColor(fcolor);
//        style.setFont(font);
//        style.setWrapText(false);
//        style.setAlignment((short)2);
//        style.setVerticalAlignment((short)1);
//        style.setFillPattern((short)1);
//        style.setFillForegroundColor(color);
//        if (isBoreder) {
//            style.setBorderRight((short)1);
//            style.setBorderBottom((short)1);
//            style.setBorderLeft((short)1);
//            style.setBorderTop((short)1);
//        }
//        return style;
//    }
//
//    public Font getFont(Workbook workbook) {
//        Font font = workbook.createFont();
//        font.setColor((new XSSFColor()).getIndexed());
//        return font;
//    }
//
//
//    public static byte[] exportExcelDataForOneBy2007(List<Map<String, String>> cellist, List<Map> datalists) {
//        logger.info(LOG_MESSAGE);
//        if (cellist != null && datalists != null) {
//            XSSFWorkbook workbook = new XSSFWorkbook();
//            XSSFSheet sheet = workbook.createSheet(SHEET);
//            sheet.setDefaultColumnWidth(20);
//            XSSFRow row = sheet.createRow(0);
//            XSSFWorkbook xssfWBook = new XSSFWorkbook();
//            XSSFCellStyle headCellstyle = xssfWBook.createCellStyle();
//            XSSFFont headFont = xssfWBook.createFont();
//            headFont.setFontName("宋体");
//            headFont.setBoldweight((short)700);
//            headFont.setFontHeightInPoints((short)12);
//            headCellstyle.setFont(headFont);
//            List<String> cellOrders = new ArrayList();
//
//            for(int j = 0; j < cellist.size(); ++j) {
//                XSSFCell cell = row.createCell(j, 1);
//                Map<String, String> map = cellist.get(j);
//                Iterator var13 = map.keySet().iterator();
//
//                while(var13.hasNext()) {
//                    String key = (String)var13.next();
//                    cellOrders.add(key);
//                    cell.setCellValue(map.get(key));
//                }
//
//                cell.setCellStyle(getCellStyle(true, (short)9, (short)32767, workbook));
//            }
//
//            long lcount = (long)datalists.size();
//
//            for(int j = 0; (long)j < lcount; ++j) {
//                Map map = datalists.get(0);
//                XSSFRow row2 = sheet.createRow(j + 1);
//
//                for(int i = 0; i < cellOrders.size(); ++i) {
//                    XSSFCell cell = row2.createCell(i);
//                    Object cellValue = map.get(cellOrders.get(i));
//                    if (cellValue != null) {
//                        if (cellValue instanceof Double) {
//                            cell.setCellValue((Double)cellValue);
//                        } else if (cellValue instanceof Date) {
//                            cell.setCellValue((new SimpleDateFormat(DateUtils.DATE_WITHOUT_TIME)).format(cellValue));
//                        } else if (cellValue instanceof BigDecimal) {
//                            cell.setCellValue(((BigDecimal)cellValue).doubleValue());
//                        } else {
//                            cell.setCellValue(cellValue.toString());
//                        }
//                    }
//                }
//
//                datalists.remove(0);
//            }
//
//            byte[] var31;
//            try (ByteArrayOutputStream out = new ByteArrayOutputStream()){
//                workbook.write(out);
//                logger.info(LOG_MESSAGE_RETURN);
//                var31 = out.toByteArray();
//                out.flush();
//            } catch (Exception var25) {
//                logger.error(var25);
//                throw new RuntimeException(var25);
//            }
//            return var31;
//        } else {
//            throw new RuntimeException("parameter can not be null");
//        }
//    }
//
//
//    /**
//     *
//     * @param cellist   中英文title_list
//     * @param datalists 数据list
//     * @return
//     */
//    public static byte[] exportExcelDataForOneForOutline(List<Map<String, String>> cellist, List<Map> datalists) {
//        logger.info(LOG_MESSAGE);
//        if (cellist != null && datalists != null) {
//            XSSFWorkbook workbook = new XSSFWorkbook();
//            XSSFSheet sheet = workbook.createSheet(SHEET);
//            sheet.setDefaultColumnWidth(20);
//            XSSFRow row = sheet.createRow(0);
//            XSSFWorkbook xssfWBook = new XSSFWorkbook();
//            XSSFCellStyle headCellstyle = xssfWBook.createCellStyle();
//            XSSFFont headFont = xssfWBook.createFont();
//            headFont.setFontName("宋体");
//            headFont.setBoldweight((short)700);
//            headFont.setFontHeightInPoints((short)12);
//            headCellstyle.setFont(headFont);
//            List<String> cellOrders = new ArrayList();
//
////            //换行
////            CellStyle cellStyle = workbook.createCellStyle();
////            cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
////            cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
////            cellStyle.setWrapText(true);
//
//
//            /**存储每列最大列宽*/
//            Map<Integer,Integer> maxWidth = new HashMap<>();
//
//            /**设置首行中文title*/
//            for(int j = 0; j < cellist.size(); ++j) {
//                XSSFCell cell = row.createCell(j, 1);
//                Map<String, String> map = cellist.get(j);
//                Iterator var13 = map.keySet().iterator();
//                while(var13.hasNext()) {
//                    String key = (String)var13.next();
//                    cellOrders.add(key);
//                    cell.setCellValue(map.get(key));
//                }
//                cell.setCellStyle(getCellStyle(true, (short)9, (short)32767, workbook));
//
//                maxWidth.put(j,cell.getStringCellValue().getBytes().length  * 250);
//            }
//
//            long lcount = (long)datalists.size();
//
//            /**新增数据行*/
//            for(int j = 0; (long)j < lcount; ++j) {
//                Map map = datalists.get(0);
//                XSSFRow row2 = sheet.createRow(j + 1);
//
//                for(int i = 0; i < cellOrders.size(); ++i) {
//                    XSSFCell cell = row2.createCell(i);
//                    //cell.setCellStyle(cellStyle);
//                    Object cellValue = map.get(cellOrders.get(i));
//                    if (cellValue != null) {
//                        if (cellValue instanceof Double) {
//                            cell.setCellValue((Double)cellValue);
//                        } else if (cellValue instanceof Date) {
//                            cell.setCellValue((new SimpleDateFormat(DateUtils.DATE_WITHOUT_TIME)).format(cellValue));
//                        } else if (cellValue instanceof BigDecimal) {
//                            cell.setCellValue(((BigDecimal)cellValue).doubleValue());
//                        } else {
//                            cell.setCellValue(cellValue.toString());
//                        }
//                    }
//
//                    int length=cell.getStringCellValue().getBytes().length  * 250;
//                    maxWidth.put(i,Math.max(length,maxWidth.get(i))); /**上下单元个取最大列宽*/
//                }
//                datalists.remove(0);
//            }
//
//            byte[] var31;
//            try (ByteArrayOutputStream out = new ByteArrayOutputStream()){
//                workbook.write(out);
//                logger.info(LOG_MESSAGE_RETURN);
//                var31 = out.toByteArray();
//            } catch (Exception var25) {
//                logger.error(var25);
//                throw new RuntimeException(var25);
//            }
//            return var31;
//        } else {
//            throw new RuntimeException("parameter can not be null");
//        }
//    }
//}
