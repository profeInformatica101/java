<?php
if (isset($_POST['submit'])) {
    $className = $_POST['className'];
    $attributes = explode(',', $_POST['attributes']);
    $methods = explode(',', $_POST['methods']);
    $generateGetSet = isset($_POST['generateGetSet']);

    header('Content-Type: text/plain');

    // Print class
    echo "public class " . $className . " {\n";

    // Print attributes
    foreach ($attributes as $attribute) {
        echo "    private String " . trim($attribute) . ";\n";
    }

    // Print getters and setters
    if ($generateGetSet) {
        foreach ($attributes as $attribute) {
            $attribute = trim($attribute);

            // Getter
            echo "\n    public String get" . ucfirst($attribute) . "() {\n";
            echo "        return this." . $attribute . ";\n";
            echo "    }\n";

            // Setter
            echo "\n    public void set" . ucfirst($attribute) . "(String " . $attribute . ") {\n";
            echo "        this." . $attribute . " = " . $attribute . ";\n";
            echo "    }\n";
        }
    }

    // Print methods
    foreach ($methods as $method) {
        echo "\n    public void " . trim($method) . "() {\n";
        echo "        // TODO: Implement " . trim($method) . "\n";
        echo "    }\n";
    }

    echo "}\n";
}
?>
