<?php
if (isset($_POST['submit'])) {
    $className = $_POST['className'];
    $attributes = explode(',', $_POST['attributes']);
    $methods = explode(',', $_POST['methods']);
    $generateGetSet = isset($_POST['generateGetSet']);

    $code = ""; // Initialize code variable

    // Add to code variable
    $code .= "public class " . $className . " {\n";

    foreach ($attributes as $attribute) {
        $code .= "    private String " . trim($attribute) . ";\n";
    }

    if ($generateGetSet) {
        foreach ($attributes as $attribute) {
            $attribute = trim($attribute);

            $code .= "\n    public String get" . ucfirst($attribute) . "() {\n";
            $code .= "        return this." . $attribute . ";\n";
            $code .= "    }\n";

            $code .= "\n    public void set" . ucfirst($attribute) . "(String " . $attribute . ") {\n";
            $code .= "        this." . $attribute . " = " . $attribute . ";\n";
            $code .= "    }\n";
        }
    }

    foreach ($methods as $method) {
        $code .= "\n    public void " . trim($method) . "() {\n";
        $code .= "        // TODO: Implement " . trim($method) . "\n";
        $code .= "    }\n";
    }

    $code .= "}\n";

    // Send the code as a downloadable file
    header('Content-Type: text/plain');
    header('Content-Disposition: attachment; filename="' . $className . '.java"');
    echo $code;
    exit;
}
?>

