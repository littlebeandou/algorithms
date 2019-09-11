package excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

public class ExcelListener extends AnalysisEventListener {

    public void invoke(Object o, AnalysisContext analysisContext) {
        ExcelPropertyUserModel userModel = (ExcelPropertyUserModel) o;
        System.out.println(userModel.getName());
    }

    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}