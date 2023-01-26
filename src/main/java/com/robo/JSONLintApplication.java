package com.robo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.robo.domain.diagnostics.MlAiModelDiaRepEntity;
import com.robo.service.MlAiModelDiaRepService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
public class JSONLintApplication {

	public static void main(String[] args) {
		SpringApplication.run(JSONLintApplication.class, args);
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


	@Bean
	CommandLineRunner classificationMetricsDiagnosticsReportRunner(MlAiModelDiaRepService diagnosticsReportService){
		return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<MlAiModelDiaRepEntity> typeReference = new TypeReference<MlAiModelDiaRepEntity>(){};
			//InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Classification_Metrics.json");
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Classification_Metrics - Modified.json");
			//InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Classification_Metrics - Modified - MlAiModelDiaRepClassificationReportEntity - Excluded MlAiModelDiaRepLiftGainEntity.json");
			//InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Classification_Metrics - Modified - Excluded MlAiModelDiaRepLiftGainEntity.json");
			try {
				MlAiModelDiaRepEntity diagnosticsReport = mapper.readValue(inputStream,typeReference);
				System.out.println("diagnosticsReports"+diagnosticsReport);
				diagnosticsReportService.save(diagnosticsReport);
				System.out.println("ClassificationMetricsDiagnosticsReport Saved!");
			} catch (IOException e){
				System.out.println("Unable to save ClassificationMetricsDiagnosticsReport: " + e.getMessage());
			}
		};
	}

	@Bean
	CommandLineRunner classificationMetricsNoThresholdDiagnosticsReportRunner(MlAiModelDiaRepService diagnosticsReportService){
		return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<MlAiModelDiaRepEntity> typeReference = new TypeReference<MlAiModelDiaRepEntity>(){};
			//InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Classification_Metrics_no_threshold.json");
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Classification_Metrics_no_threshold - Modified.json");
			//InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Classification_Metrics_no_threshold - Modified - Excluded MlAiModelDiaRepLiftGainEntity.json");
			try {
				MlAiModelDiaRepEntity diagnosticsReport = mapper.readValue(inputStream,typeReference);
				System.out.println("diagnosticsReports"+diagnosticsReport);
				diagnosticsReportService.save(diagnosticsReport);
				System.out.println("ClassificationMetricsNoThresholdDiagnosticsReport Saved!");
			} catch (IOException e){
				System.out.println("Unable to save ClassificationMetricsNoThresholdDiagnosticsReport: " + e.getMessage());
			}
		};
	}


	@Bean
	CommandLineRunner continuousMetricsDiagnosticsReportRunner(MlAiModelDiaRepService diagnosticsReportService){
		return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<MlAiModelDiaRepEntity> typeReference = new TypeReference<MlAiModelDiaRepEntity>(){};
			//InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Continuous_Metrics.json");
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Continuous_Metrics - Modified.json");
			try {
				MlAiModelDiaRepEntity diagnosticsReport = mapper.readValue(inputStream,typeReference);
				System.out.println("ContinuousMetricsDiagnosticsReport"+diagnosticsReport);
				diagnosticsReportService.save(diagnosticsReport);
				System.out.println("ContinuousMetricsDiagnosticsReport Saved!");
			} catch (IOException e){
				System.out.println("Unable to save ContinuousMetricsDiagnosticsReport: " + e.getMessage());
			}
		};
	}
}
