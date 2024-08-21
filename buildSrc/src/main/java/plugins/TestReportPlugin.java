package plugins;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.testing.jacoco.plugins.JacocoPlugin;

public class TestReportPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        project.getPluginManager().apply(JacocoPlugin.class);
        project.getTasks().register("generateTestReport", task -> {
            task.setGroup("reporting");
            task.setDescription("generates a test coverage report using Jacoco.");
            task.dependsOn("jacocoTestReport");
        });
    }
}
