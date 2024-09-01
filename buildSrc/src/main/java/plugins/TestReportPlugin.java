package plugins;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.file.FileCollection;
import org.gradle.api.plugins.JavaPluginExtension;
import org.gradle.testing.jacoco.plugins.JacocoPlugin;
import org.gradle.testing.jacoco.tasks.JacocoReport;

import java.io.File;
import java.util.stream.Collectors;

public class TestReportPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.getPluginManager().apply(JacocoPlugin.class);
        project.getTasks().register("generateTestReport", JacocoReport.class, task -> {
            task.setGroup("reporting");
            task.setDescription("generates a global test coverage report using Jacoco.");
            FileCollection allSourceDirs = project.files(
                    project.getAllprojects().stream()
                            .flatMap(subproject -> {
                                JavaPluginExtension javaPluginExtension = subproject.getExtensions().findByType(JavaPluginExtension.class);
                                return javaPluginExtension != null
                                        ? javaPluginExtension.getSourceSets().getByName("main").getAllSource().getSrcDirs().stream()
                                        : null;
                            })
                            .collect(Collectors.toList())
            );
            FileCollection allClassDirs = project.files(
                    project.getAllprojects().stream()
                            .flatMap(subproject -> {
                                JavaPluginExtension javaPluginExtension = subproject.getExtensions().findByType(JavaPluginExtension.class);
                                return javaPluginExtension != null
                                        ? javaPluginExtension.getSourceSets().getByName("main").getOutput().getClassesDirs().getFiles().stream()
                                        : null;
                            })
                            .collect(Collectors.toList())
            );
            FileCollection allExecutionData = project.files(
                    project.getAllprojects().stream()
                            .flatMap(subproject -> subproject.getTasks().withType(JacocoReport.class).stream()
                                    .map(JacocoReport::getExecutionData)
                                    .flatMap(executionData -> executionData.getFiles().stream()))
                            .filter(File::exists)
                            .collect(Collectors.toList())
            );

            task.getAdditionalSourceDirs().setFrom(allSourceDirs);
            task.getSourceDirectories().setFrom(allSourceDirs);
            task.getClassDirectories().setFrom(allClassDirs);
            task.getExecutionData().setFrom(allExecutionData);
            task.dependsOn(project.getAllprojects().stream()
                    .map(subproject -> subproject.getTasks().withType(Task.class).getByName("test"))
                    .collect(Collectors.toList()));
        });
    }
}
