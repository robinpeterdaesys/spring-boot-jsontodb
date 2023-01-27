package com.robo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.robo.domain.diagnostics.MlAiModelDiaReportEntity;
import com.robo.service.MlAiModelDiaRepService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.time.Instant;

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
			Instant start = Instant.now();
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<MlAiModelDiaReportEntity> typeReference = new TypeReference<MlAiModelDiaReportEntity>(){};
			//InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Classification_Metrics.json");
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Classification_Metrics - Modified.json");
			//InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Classification_Metrics - Modified - MlAiModelDiaRepClassificationReportEntity - Excluded MlAiModelDiaRepLiftGainEntity.json");
			//InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Classification_Metrics - Modified - Excluded MlAiModelDiaRepLiftGainEntity.json");
			try {
				MlAiModelDiaReportEntity diagnosticsReport = mapper.readValue(inputStream,typeReference);
				diagnosticsReportService.save(diagnosticsReport);
				System.out.println("ClassificationMetricsDiagnosticsReport Saved!");
			} catch (IOException e){
				System.out.println("Unable to save ClassificationMetricsDiagnosticsReport: " + e.getMessage());
			}
			Instant end = Instant.now();
			Duration timeElapsed = Duration.between(start, end);
			System.out.println("-----classificationMetricsDiagnosticsReportRunner-----timeElapsed---->>>>\n"+timeElapsed.getSeconds());
		};
	}

	@Bean
	CommandLineRunner classificationMetricsNoThresholdDiagnosticsReportRunner(MlAiModelDiaRepService diagnosticsReportService){
		return args -> {
			Instant start = Instant.now();
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<MlAiModelDiaReportEntity> typeReference = new TypeReference<MlAiModelDiaReportEntity>(){};
			//InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Classification_Metrics_no_threshold.json");
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Classification_Metrics_no_threshold - Modified.json");
			//InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Classification_Metrics_no_threshold - Modified - Excluded MlAiModelDiaRepLiftGainEntity.json");
			try {
				MlAiModelDiaReportEntity diagnosticsReport = mapper.readValue(inputStream,typeReference);
				diagnosticsReportService.save(diagnosticsReport);
				System.out.println("ClassificationMetricsNoThresholdDiagnosticsReport Saved!");
			} catch (IOException e){
				System.out.println("Unable to save ClassificationMetricsNoThresholdDiagnosticsReport: " + e.getMessage());
			}
			Instant end = Instant.now();
			Duration timeElapsed = Duration.between(start, end);
			System.out.println("-----classificationMetricsNoThresholdDiagnosticsReportRunner-----timeElapsed---->>>>\n"+timeElapsed.getSeconds());
		};
	}


	@Bean
	CommandLineRunner continuousMetricsDiagnosticsReportRunner(MlAiModelDiaRepService diagnosticsReportService){
		return args -> {
			Instant start = Instant.now();
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<MlAiModelDiaReportEntity> typeReference = new TypeReference<MlAiModelDiaReportEntity>(){};
			//InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Continuous_Metrics.json");
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Continuous_Metrics - Modified.json");
			try {
				MlAiModelDiaReportEntity diagnosticsReport = mapper.readValue(inputStream,typeReference);
				diagnosticsReportService.save(diagnosticsReport);
				System.out.println("ContinuousMetricsDiagnosticsReport Saved!");
			} catch (IOException e){
				System.out.println("Unable to save ContinuousMetricsDiagnosticsReport: " + e.getMessage());
			}
			Instant end = Instant.now();
			Duration timeElapsed = Duration.between(start, end);
			System.out.println("-----continuousMetricsDiagnosticsReportRunner-----timeElapsed---->>>>\n"+timeElapsed.getSeconds());
		};
	}
}
