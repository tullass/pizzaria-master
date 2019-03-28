//package mz.co.schoolCtrl.propertyeditors;
//
//import java.beans.PropertyEditorSupport;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import mz.co.schoolCtrl.model.Grade;
//import mz.co.schoolCtrl.repository.GradeRepository;
//
//@Component
//public class IngredientePropertyEditor extends PropertyEditorSupport {
//
//	@Autowired
//	private GradeRepository gradeRepository;
//	
//	@Override
//	public void setAsText(String text) throws IllegalArgumentException {
//		Long idIngrediente = Long.parseLong(text);
//		Grade grade = gradeRepository.findOne(idIngrediente);
//		setValue(grade);
//	}
//	
//}
