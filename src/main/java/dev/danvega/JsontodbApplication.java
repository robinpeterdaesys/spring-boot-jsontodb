package dev.danvega;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.danvega.domain.users.User;
import dev.danvega.domain.diagnostics.DiagnosticsReport;
import dev.danvega.service.DiagnosticsReportService;
import dev.danvega.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class JsontodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsontodbApplication.class, args);
	}
//
//	@Bean
//	CommandLineRunner userRunner(UserService userService){
//	    return args -> {
//			// read JSON and load json
//			ObjectMapper mapper = new ObjectMapper();
//			TypeReference<List<User>> typeReference = new TypeReference<List<User>>(){};
//			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
//			try {
//				List<User> users = mapper.readValue(inputStream,typeReference);
//				userService.save(users);
//				System.out.println("Users Saved!");
//			} catch (IOException e){
//				System.out.println("Unable to save users: " + e.getMessage());
//			}
//	    };
//	}

//	@Bean
//	CommandLineRunner continuousMetricsDiagnosticsReportRunner(DiagnosticsReportService diagnosticsReportService){
//		return args -> {
//			// read JSON and load json
//			ObjectMapper mapper = new ObjectMapper();
//			TypeReference<DiagnosticsReport> typeReference = new TypeReference<DiagnosticsReport>(){};
//			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Continuous_Metrics_v0 - Modified.json");
//			try {
//				DiagnosticsReport diagnosticsReport = mapper.readValue(inputStream,typeReference);
//				System.out.println("ContinuousMetricsDiagnosticsReport"+diagnosticsReport);
//				diagnosticsReportService.save(diagnosticsReport);
//				System.out.println("ContinuousMetricsDiagnosticsReport Saved!");
//			} catch (IOException e){
//				System.out.println("Unable to save ContinuousMetricsDiagnosticsReport: " + e.getMessage());
//			}
//		};
//	}

//	@Bean
//	CommandLineRunner classificationMetricsDiagnosticsReportExcLiftRunner(DiagnosticsReportService diagnosticsReportService){
//		return args -> {
//			// read JSON and load json
//			ObjectMapper mapper = new ObjectMapper();
//			TypeReference<DiagnosticsReport> typeReference = new TypeReference<DiagnosticsReport>(){};
//			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Classification_Metrics_v2 - Modified - Excluded LiftGain.json");
//			try {
//				DiagnosticsReport diagnosticsReport = mapper.readValue(inputStream,typeReference);
//				System.out.println("diagnosticsReports"+diagnosticsReport);
//				diagnosticsReportService.save(diagnosticsReport);
//				System.out.println("ClassificationMetricsDiagnosticsReport Saved!");
//			} catch (IOException e){
//				System.out.println("Unable to save ClassificationMetricsDiagnosticsReport: " + e.getMessage());
//			}
//		};
//	}
	@Bean
	CommandLineRunner classificationMetricsDiagnosticsReportRunner(DiagnosticsReportService diagnosticsReportService){
		return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<DiagnosticsReport> typeReference = new TypeReference<DiagnosticsReport>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Classification_Metrics_v2 - Modified.json");
			try {
				DiagnosticsReport diagnosticsReport = mapper.readValue(inputStream,typeReference);
				System.out.println("diagnosticsReports"+diagnosticsReport);
				diagnosticsReportService.save(diagnosticsReport);
				System.out.println("ClassificationMetricsDiagnosticsReport Saved!");
			} catch (IOException e){
				System.out.println("Unable to save ClassificationMetricsDiagnosticsReport: " + e.getMessage());
			}
		};
	}

//	@Bean
//	CommandLineRunner classificationMetricsNoThresholdDiagnosticsReportRunner(DiagnosticsReportService diagnosticsReportService){
//		return args -> {
//			// read JSON and load json
//			ObjectMapper mapper = new ObjectMapper();
//			TypeReference<DiagnosticsReport> typeReference = new TypeReference<DiagnosticsReport>(){};
//			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Classification_Metrics_no_threshold - Modified - Excluded LiftGain.json");
//			try {
//				DiagnosticsReport diagnosticsReport = mapper.readValue(inputStream,typeReference);
//				System.out.println("diagnosticsReports"+diagnosticsReport);
//				diagnosticsReportService.save(diagnosticsReport);
//				System.out.println("ClassificationMetricsNoThresholdDiagnosticsReport Saved!");
//			} catch (IOException e){
//				System.out.println("Unable to save ClassificationMetricsNoThresholdDiagnosticsReport: " + e.getMessage());
//			}
//		};
//	}
}
