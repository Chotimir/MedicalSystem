package com.medicalsystem.excel.export;


import com.medicalsystem.excel.ExcelColumnsProperties;
import com.medicalsystem.model.Admission;
import com.medicalsystem.model.Patient;
import com.medicalsystem.service.AdmissionService;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjectExporter {

    private AdmissionService admissionService;
    private ExcelColumnsProperties prop;
    private CellBuilder cellBuilder;
    private Row row;

    @Autowired
    public ObjectExporter(AdmissionService admissionService, ExcelColumnsProperties prop, CellBuilder cellBuilder) {
        this.admissionService = admissionService;
        this.prop = prop;
        this.cellBuilder = cellBuilder;
    }

    public void saveDataIntoRow(Row row, int admissionId) {
        this.row = row;

        Admission admission = admissionService.getById(admissionId);
        Patient patient = admission.getPatient();

        savePatient(patient);

    }

    private void savePatient(Patient patient) {
        cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("id.number"), patient.getId());
        cellBuilder.saveStringInRow(row, prop.getColumnPropertyAsInt("firstName.number"), patient.getFirstName());
        cellBuilder.saveStringInRow(row, prop.getColumnPropertyAsInt("lastName.number"), patient.getLastName());
        cellBuilder.saveStringInRow(row, prop.getColumnPropertyAsInt("sex.number"), patient.getSex());
        cellBuilder.saveIntInRow(row, prop.getColumnPropertyAsInt("age.number"), patient.getAge());
        //TODO: DiseaseDescription

    }




}
